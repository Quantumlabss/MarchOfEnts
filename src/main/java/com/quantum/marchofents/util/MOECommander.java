package com.quantum.marchofents.util;

import java.lang.reflect.Constructor;
import java.util.Locale;
import java.util.Map;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.*;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.relauncher.ReflectionHelper;
import lotr.common.LOTRShields;
import lotr.common.fac.LOTRFaction;
import lotr.common.item.LOTRItemBanner;
import lotr.common.item.LOTRItemBanner.BannerType;
import lotr.common.util.LOTRLog;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;

public class MOECommander {
	
	public static int lastBannerID = 52;
	
	public static LOTRShields addAlignmentShield(String enumName, LOTRFaction faction) {
		Class<?>[] classArr = {LOTRFaction.class};
		Object[] args = {faction};
		return EnumHelper.addEnum(LOTRShields.class, enumName, classArr, args);
	}
	
	public static LOTRItemBanner.BannerType addBanner(String name, LOTRFaction faction) {
		int id = lastBannerID++;
		LOTRItemBanner.BannerType banner = EnumHelper.addEnum(LOTRItemBanner.BannerType.class, name.toUpperCase(Locale.ROOT), new Class[]{Integer.TYPE, String.class, LOTRFaction.class}, new Object[]{id, name, faction});
		LOTRItemBanner.BannerType.bannerTypes.add(banner);
		Map<Integer, BannerType> map = ReflectionHelper.getPrivateValue(BannerType.class, null, "bannerForID");
		LOTRItemBanner.BannerType prior = map.put(id, banner);
		return banner;
	}
	

	public static <E> E findAndInvokeConstructor(Object[] args, Class<E> clazz, Class<?>... parameterTypes) {
		Constructor<E> constructor = findConstructor(clazz, parameterTypes);
		constructor.setAccessible(true);
		try {
			return constructor.newInstance(args);
		} catch (IllegalAccessException | IllegalArgumentException | InstantiationException |
		         InvocationTargetException e) {
			LOTRLog.logger.error("Error when initializing constructor from class {} with parameters {}", clazz.getSimpleName(), args);
			e.printStackTrace();
			return null;
		}
	}

	private static <T, E> T findAndInvokeMethod(Class<? super E> clazz, E instance, String methodName) {
		return findAndInvokeMethod(new Object[0], clazz, instance, methodName);
	}

	public static <T, E> void findAndInvokeMethod(Object arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		findAndInvokeMethod(new Object[]{arg}, clazz, instance, new String[]{methodName}, methodTypes);
	}

	public static <T, E> T findAndInvokeMethod(Object[] arg, Class<? super E> clazz, E instance, String methodName, Class<?>... methodTypes) {
		return findAndInvokeMethod(arg, clazz, instance, new String[]{methodName}, methodTypes);
	}

	public static <T, E> T findAndInvokeMethod(Object[] args, Class<? super E> clazz, E instance, String[] methodNames, Class<?>... methodTypes) {
		//Method addControlZoneMethod = ReflectionHelper.findMethod(clazz, instance, methodNames, methodTypes);
	//	try {
		//	return (T) addControlZoneMethod.invoke(instance, args);
		//} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		//	e.printStackTrace();
			return null;
	//	}
	}

	public static <E> Constructor<E> findConstructor(Class<E> clazz, Class<?>... parameterTypes) {
		try {
			return clazz.getDeclaredConstructor(parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			LOTRLog.logger.error("Error when getting constructor from class {} with parameters {}", clazz.getSimpleName(), parameterTypes);
			e.printStackTrace();
			return null;
		}
	}
	
	public static ModContainer getContainer(ResourceLocation res) {
		ModContainer modContainer = Loader.instance().getIndexedModList().get(res.getResourceDomain());
		if (modContainer == null) {
			throw new IllegalArgumentException("Can't find the mod container for the domain " + res.getResourceDomain());
		}
		return modContainer;
	}
	

	public static InputStream getInputStream(ModContainer container, String path) {
		return container.getClass().getResourceAsStream(path);
	}

	public static InputStream getInputStream(ResourceLocation res) {
		return getInputStream(getContainer(res), getPath(res));
	}
	

	
	
	public static <E, T> List<T> getObjectFieldsOfType(Class<? extends E> clazz, Class<? extends T> type) {
		return getObjectFieldsOfType(clazz, null, type);
	}

	public static <E, T> List<T> getObjectFieldsOfType(Class<? extends E> clazz, E instance, Class<? extends T> type) {
		List<T> list = new ArrayList<>();
		try {
			for (Field field : clazz.getDeclaredFields()) {
				if (field != null) {
					Object fieldObj = null;
					if (Modifier.isStatic(field.getModifiers())) {
						fieldObj = field.get(null);
					} else if (instance != null) {
						fieldObj = field.get(instance);
					}
					if (fieldObj != null && type.isAssignableFrom(fieldObj.getClass())) {
						list.add((T) fieldObj);
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException ignored) {

		}
		return list;
	}

	public static String getPath(ResourceLocation res) {
		return "/assets/" + res.getResourceDomain() + "/" + res.getResourcePath();
	}
	
	public static void setShieldTexture(LOTRShields shield, ResourceLocation resourceLocation) {
		try {
			Field privateField = LOTRShields.class.getDeclaredField("shieldTexture");
			privateField.setAccessible(true);
			privateField.set(shield, resourceLocation);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e2) {
			e2.printStackTrace();
		}
	}
	


}

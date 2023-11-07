package com.quantum.marchofents.util;

import java.lang.reflect.Constructor;

import com.quantum.marchofents.MarchOfEnts;
import com.quantum.marchofents.init.Items;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.*;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.relauncher.ReflectionHelper;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRShields;
import lotr.common.fac.LOTRFaction;
import lotr.common.fac.*;
import lotr.common.world.map.*;
import lotr.common.world.structure2.scan.*;
import lotr.common.util.*;
import lotr.common.world.biome.*;
import lotr.common.world.feature.*;
import lotr.common.entity.projectile.*;
import lotr.client.*;
import lotr.common.*;

import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRItemBanner;
import lotr.common.item.LOTRItemBanner.BannerType;
import lotr.common.item.LOTRMaterial;
import lotr.common.quest.LOTRMiniQuest;
import lotr.common.quest.LOTRMiniQuestFactory;
import lotr.common.util.LOTRLog;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;

public class MOECommander {
	
	public static int lastBannerID = 52;
	
	public static LOTRShields addAlignmentShield(String enumName, LOTRFaction faction) {
		Class<?>[] classArr = {LOTRFaction.class};
		Object[] args = {faction};
		return EnumHelper.addEnum(LOTRShields.class, enumName, classArr, args);
	}
	public static LOTRAchievement.Category addAchievementCategory(String enumName, LOTRFaction faction) {
		Class<?>[] classArr = {LOTRFaction.class};
		Object[] args = {faction};
		return EnumHelper.addEnum(LOTRAchievement.Category.class, enumName, classArr, args);
	}
	
	public static LOTRItemBanner.BannerType addBanner(String name, LOTRFaction faction) {
		int id = lastBannerID++;
		LOTRItemBanner.BannerType banner = EnumHelper.addEnum(LOTRItemBanner.BannerType.class, name.toUpperCase(Locale.ROOT), new Class[]{Integer.TYPE, String.class, LOTRFaction.class}, new Object[]{id, name, faction});
		LOTRItemBanner.BannerType.bannerTypes.add(banner);
		Map<Integer, BannerType> map = ReflectionHelper.getPrivateValue(BannerType.class, null, "bannerForID");
		LOTRItemBanner.BannerType prior = map.put(id, banner);
		return banner;
	}
	
	public static void addMiniQuest(LOTRMiniQuestFactory factory, LOTRMiniQuest.QuestFactoryBase<? extends LOTRMiniQuest> questFactory) {
		findAndInvokeMethod(questFactory, LOTRMiniQuestFactory.class, factory, "addQuest", LOTRMiniQuest.QuestFactoryBase.class);
	}

	public static LOTRMiniQuestFactory addMiniQuestFactory(String enumName, String name) {
		Class<?>[] classArr = {String.class};
		Object[] args = {name};
		return EnumHelper.addEnum(LOTRMiniQuestFactory.class, enumName, classArr, args);
	}
	
	public static List<Item> getAllMOEItems(){
		return MOECommander.getObjectFieldsOfType(Items.class, Item.class);
	}
	public static void setMiniQuestFactoryAchievement(LOTRMiniQuestFactory factory, LOTRAchievement achievement) {
		findAndInvokeMethod(achievement, LOTRMiniQuestFactory.class, factory, "setAchievement", LOTRAchievement.class);
	}
	
    public static <E, T> List<T> getObjectFieldsOfType(final Class<? extends E> clazz, final Class<? extends T> type) {
        return getObjectFieldsOfType((Class<?>)clazz, (Object)null, type);
    }
    
    public static <E, T> List<T> getObjectFieldsOfType(final Class<? extends E> clazz, final E instance, final Class<? extends T> type) {
        final List<T> list = new ArrayList<T>();
        try {
            for (final Field field : clazz.getDeclaredFields()) {
                if (field != null) {
                    Object fieldObj = null;
                    if (Modifier.isStatic(field.getModifiers())) {
                        fieldObj = field.get(null);
                    }
                    else if (instance != null) {
                        fieldObj = field.get(instance);
                    }
                    if (fieldObj != null) {
                        if (type.isAssignableFrom(fieldObj.getClass())) {
                            list.add((T)fieldObj);
                        }
                    }
                }
            }
        }
        catch (IllegalArgumentException | IllegalAccessException ex2) {
            final Exception ex = null;
            final Exception e = ex;
            MarchOfEnts.logger.error("Errored when getting all field from: " + clazz.getName() + " of type: " + type.getName());
        }
        return list;
    }
    
    public static <T, E> void setFinalField(final Class<? super T> classToAccess, final T instance, final E value, final String... fieldNames) {
        try {
            LOTRReflection.setFinalField((Class)classToAccess, (Object)instance, (Object)value, fieldNames);
        }
        catch (Exception e) {
            MarchOfEnts.logger.error("Error when setting field: " + fieldNames[0] + " for class: " + classToAccess.getName());
            e.printStackTrace();
        }
    }
    
    private static <T, E> T findAndInvokeMethod(final Class<? super E> clazz, final E instance, final String methodName) {
        return findAndInvokeMethod(new Object[0], clazz, instance, methodName, (Class<?>[])new Class[0]);
    }
    
    private static <T, E> T findAndInvokeMethod(final Object arg, final Class<? super E> clazz, final E instance, final String methodName, final Class<?>... methodTypes) {
        return findAndInvokeMethod(new Object[] { arg }, clazz, instance, new String[] { methodName }, methodTypes);
    }
    
    private static <T, E> T findAndInvokeMethod(final Object[] arg, final Class<? super E> clazz, final E instance, final String methodName, final Class<?>... methodTypes) {
        return findAndInvokeMethod(arg, clazz, instance, new String[] { methodName }, methodTypes);
    }
    
    private static <T, E> T findAndInvokeMethod(final Object[] args, final Class<? super E> clazz, final E instance, final String[] methodNames, final Class<?>... methodTypes) {
        final Method addControlZoneMethod = ReflectionHelper.findMethod((Class)clazz, (Object)instance, methodNames, (Class[])methodTypes);
        try {
            return (T)addControlZoneMethod.invoke(instance, args);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex2) {
            final Exception ex = null;
            final Exception e = ex;
            MarchOfEnts.logger.error("Error when getting method " + methodNames[0] + " from class " + clazz.getSimpleName());
            e.printStackTrace();
            return null;
        }
    }
    
    private static <E> E findAndInvokeConstructor(final String className, final Class<?>... parameterTypes) {
        return findAndInvokeConstructor(new Object[0], className, parameterTypes);
    }
    
    private static <E> E findAndInvokeConstructor(final Object[] args, final String className, final Class<?>... parameterTypes) {
        try {
            return (E) findAndInvokeConstructor(args, Class.forName(className), parameterTypes);
        }
        catch (ClassNotFoundException e) {
            MarchOfEnts.logger.error("Error when finding class " + className + " for a constructor.");
            e.printStackTrace();
            return null;
        }
    }
    
    private static <E> E findAndInvokeConstructor(final Class<E> clazz, final Object... args) {
        final Class<?>[] paramaterTypes = (Class<?>[])new Class[args.length];
        for (int i = 0; i < args.length; ++i) {
            paramaterTypes[i] = args[i].getClass();
        }
        return findAndInvokeConstructor(args, clazz, paramaterTypes);
    }
    
    private static <E> E findAndInvokeConstructor(final Object[] args, final Class<E> clazz, final Class<?>... parameterTypes) {
        final Constructor<E> constructor = findConstructor(clazz, parameterTypes);
        constructor.setAccessible(true);
        try {
            return constructor.newInstance(args);
        }
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex2) {
            final Exception ex = null;
            final Exception e = ex;
            MarchOfEnts.logger.error("Error when initializing constructor from class " + clazz.getSimpleName() + " with parameters " + args);
            e.printStackTrace();
            return null;
        }
    }
    
    private static <E> Constructor<E> findConstructor(final Class<E> clazz, final Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredConstructor(parameterTypes);
        }
        catch (NoSuchMethodException | SecurityException ex2) {
            final Exception ex = null;
            final Exception e = ex;
            MarchOfEnts.logger.error("Error when getting constructor from class " + clazz.getSimpleName() + " with parameters " + parameterTypes);
            e.printStackTrace();
            return null;
        }
    }




    
    public static String getArmorName(final LOTRItemArmor armor) {
        return findAndInvokeMethod(LOTRItemArmor.class, armor, "getArmorName");
    }
    
    public static void setMaterialCraftingItem(final LOTRMaterial material, final Item item) {
        setMaterialCraftingItem(material, item, item);
    }
    
    public static void setMaterialCraftingItem(final LOTRMaterial material, final Item toolItem, final Item armorItem) {
        findAndInvokeMethod(new Object[] { toolItem, armorItem }, LOTRMaterial.class, material, "setCraftingItems", Item.class, Item.class);
    }
    public static void setToolMaterialRepairItem(final Item.ToolMaterial material, final ItemStack item) {
        ReflectionHelper.setPrivateValue((Class)Item.ToolMaterial.class, (Object)material, (Object)item, new String[] { "repairMaterial" });
    }
	
	public static void setFactionAchievementCategory(LOTRFaction faction, LOTRAchievement.Category category) {
		ReflectionHelper.setPrivateValue(LOTRFaction.class, faction, category, "achieveCategory");
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

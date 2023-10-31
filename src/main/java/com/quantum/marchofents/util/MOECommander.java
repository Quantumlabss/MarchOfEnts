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
import lotr.common.LOTRShields;
import lotr.common.fac.LOTRFaction;
import lotr.common.item.LOTRItemBanner;
import lotr.common.item.LOTRItemBanner.BannerType;
import lotr.common.util.LOTRLog;
import net.minecraft.item.Item;
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
	
	public static List<Item> getAllMOEItems(){
		return MOECommander.getObjectFieldsOfType(Items.class, Item.class);
	}
	
    public static <E, T> List<T> getObjectFieldsOfType(Class<? extends E> clazz, Class<? extends T> type) {
        return MOECommander.getObjectFieldsOfType(clazz, null, type);
    }

    public static <E, T> List<T> getObjectFieldsOfType(Class<? extends E> clazz, E instance, Class<? extends T> type) {
        ArrayList<Object> list = new ArrayList<Object>();
        try {
            for (Field field : clazz.getDeclaredFields()) {
                if (field == null) continue;
                Object fieldObj = null;
                if (Modifier.isStatic(field.getModifiers())) {
                    fieldObj = field.get(null);
                } else if (instance != null) {
                    fieldObj = field.get(instance);
                }
                if (fieldObj == null || !type.isAssignableFrom(fieldObj.getClass())) continue;
                list.add(fieldObj);
            }
        }
        catch (IllegalAccessException | IllegalArgumentException e) {
            MarchOfEnts.logger.error("Errored when getting all field from: " + clazz.getName() + " of type: " + type.getName());
        }
        return (List<T>) list;
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

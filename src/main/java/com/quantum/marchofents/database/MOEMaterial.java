package com.quantum.marchofents.database;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.quantum.marchofents.MarchOfEnts;
import com.quantum.marchofents.util.MOECommander;

import lotr.common.LOTRMod;
import lotr.common.fac.LOTRFaction;
import lotr.common.item.LOTRItemGuldurilCrystal;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class MOEMaterial {
	public static LOTRMaterial LEBENNIN;
	public static LOTRMaterial FINGOLFIN;
	public static LOTRMaterial HIGH_ELVEN_ELITE;
	public static LOTRMaterial ELVEN_CIRCLET;
	public static LOTRMaterial DRAGON_HELM;
	public static LOTRMaterial FANGORN;
	public static LOTRMaterial ENTISH;
	public static LOTRMaterial SAURON;
	public static LOTRMaterial LOSSARNACH;
	public static LOTRMaterial GONDOR_CROWN;
    public static LOTRMaterial BALROG;
	private static boolean setup;
	private static Constructor<LOTRMaterial> constructor;
    private static Method setUses;
    private static Method setDamage;
    private static Method setProtection;
    private static Method setSpeed;
    private static Method setHarvestLevel;
    private static Method setEnchantibility;
    private static Method setCraftingMaterial;
    private static Method setUndamageable;
    private static Method setManFlesh;
    
    public static void setupCraftingItems() {
    	MOECommander.setMaterialCraftingItem(MOEMaterial.LEBENNIN, LOTRMod.ancientItem);
    }
    public static void changeLOTRMaterials() {
    	
    }
    private static LOTRMaterial newLOTRMaterial(final String name, final int uses, final float damage, final float protection, final float speed, final int harvestLevel, final int enchantability, final Item craftingMaterial) {
        return newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, false);
    }
    
    private static LOTRMaterial newLOTRMaterial(final String name, final int uses, final float damage, final float protection, final float speed, final int harvestLevel, final int enchantability, final Item craftingMaterial, final boolean manFlesh) {
        return newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterial, craftingMaterial, manFlesh, false);
    }
    
    private static LOTRMaterial newLOTRMaterial(final String name, final int uses, final float damage, final float protection, final float speed, final int harvestLevel, final int enchantability, final Item craftingMaterialTool, final Item craftingMaterialArmor) {
        return newLOTRMaterial(name, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterialTool, craftingMaterialArmor, false, false);
    }
    
    private static LOTRMaterial newLOTRMaterial(final String name, final int uses, final float damage, final float protection, final float speed, final int harvestLevel, final int enchantability, final Item craftingMaterialTool, final Item craftingMaterialArmor, final boolean manFlesh, final boolean undamageable) {
        setup();
        LOTRMaterial material = null;
        try {
            material = MOEMaterial.constructor.newInstance(name);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex2) {
            final Exception ex = null;
            final Exception e = ex;
            MarchOfEnts.logger.error("Failed to create LOTRMaterial " + name, (Throwable)e);
        }
        return editLOTRMaterial(material, uses, damage, protection, speed, harvestLevel, enchantability, craftingMaterialTool, craftingMaterialArmor, manFlesh, undamageable);
    }
    private static LOTRMaterial editLOTRMaterial(final LOTRMaterial material, final int uses, final float damage, final float protection, final float speed, final int harvestLevel, final int enchantability, final Item craftingMaterialTool, final Item craftingMaterialArmor, final boolean manFlesh, final boolean undamageable) {
        setup();
        try {
            if (uses != -1) {
                MOEMaterial.setUses.invoke(material, uses);
            }
            if (damage != -1.0f) {
                MOEMaterial.setDamage.invoke(material, damage);
            }
            if (protection != -1.0f) {
                MOEMaterial.setProtection.invoke(material, protection);
            }
            if (speed != -1.0f) {
                MOEMaterial.setSpeed.invoke(material, speed);
            }
            if (harvestLevel != -1) {
                MOEMaterial.setHarvestLevel.invoke(material, harvestLevel);
            }
            if (enchantability != -1) {
                MOEMaterial.setEnchantibility.invoke(material, enchantability);
            }
            if (craftingMaterialTool != null && craftingMaterialArmor != null) {
                MOEMaterial.setCraftingMaterial.invoke(material, craftingMaterialTool, craftingMaterialArmor);
            }
            if (undamageable) {
                MOEMaterial.setUndamageable.invoke(material, new Object[0]);
            }
            if (manFlesh) {
                MOEMaterial.setManFlesh.invoke(material, new Object[0]);
            }
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex2) {
            final Exception ex = null;
            final Exception e = ex;
            MarchOfEnts.logger.error("Failed to edit LOTRMaterial " + material.toString(), (Throwable)e);
        }
        return material;
    }
    
    private static void setup() {
        if (MOEMaterial.setup) {
            return;
        }
        try {
            final Class<LOTRMaterial> clazz = LOTRMaterial.class;
            (MOEMaterial.constructor = clazz.getDeclaredConstructor(String.class)).setAccessible(true);
            (MOEMaterial.setUses = clazz.getDeclaredMethod("setUses", Integer.TYPE)).setAccessible(true);
            (MOEMaterial.setDamage = clazz.getDeclaredMethod("setDamage", Float.TYPE)).setAccessible(true);
            (MOEMaterial.setProtection = clazz.getDeclaredMethod("setProtection", Float.TYPE)).setAccessible(true);
            (MOEMaterial.setSpeed = clazz.getDeclaredMethod("setSpeed", Float.TYPE)).setAccessible(true);
            (MOEMaterial.setHarvestLevel = clazz.getDeclaredMethod("setHarvestLevel", Integer.TYPE)).setAccessible(true);
            (MOEMaterial.setEnchantibility = clazz.getDeclaredMethod("setEnchantability", Integer.TYPE)).setAccessible(true);
            (MOEMaterial.setCraftingMaterial = clazz.getDeclaredMethod("setCraftingItems", Item.class, Item.class)).setAccessible(true);
            (MOEMaterial.setUndamageable = clazz.getDeclaredMethod("setUndamageable", (Class<?>[])new Class[0])).setAccessible(true);
            (MOEMaterial.setManFlesh = clazz.getDeclaredMethod("setManFlesh", (Class<?>[])new Class[0])).setAccessible(true);
            MOEMaterial.setup = true;
        }
        catch (NoSuchMethodException | SecurityException ex2) {
            final Exception ex = null;
            final Exception e = ex;
            MarchOfEnts.logger.error("Failed to setup LOTRFAMaterials.", (Throwable)e);
        }
    }
    
    private static void setExistingCraftingItem(final LOTRMaterial material, final Item item) {
        setExistingCraftingItem(material, new ItemStack(item), item);
    }
    
    private static void setExistingCraftingItem(final LOTRMaterial material, final ItemStack toolItem, final Item armorItem) {
        MOECommander.setToolMaterialRepairItem(material.toToolMaterial(), toolItem);
        material.toArmorMaterial().customCraftingMaterial = armorItem;
    }
    
    public static ItemArmor.ArmorMaterial getFullArmorMaterial(final EntityLivingBase entity) {
        ItemArmor.ArmorMaterial material = null;
        for (int i = 1; i <= 4; ++i) {
            final ItemStack item = entity.getEquipmentInSlot(i);
            if (item == null || !(item.getItem() instanceof ItemArmor)) {
                return null;
            }
            final ItemArmor.ArmorMaterial itemMaterial = ((ItemArmor)item.getItem()).getArmorMaterial();
            if (material != null && itemMaterial != material) {
                return null;
            }
            material = itemMaterial;
        }
        return material;
    }
    
    static {
    	
    	MOEMaterial.LEBENNIN = newLOTRMaterial("LEBENNIN", 450, 0.0f, 0.5f, 0.0f, 0, 15, null);
    	MOEMaterial.FINGOLFIN = newLOTRMaterial("FINGOLFIN", 700, 3.0f, 0.6f, 7.0f, 2, 15, null);
    	MOEMaterial.HIGH_ELVEN_ELITE = newLOTRMaterial("HIGH_ELVEN_ELITE", 700, 3.0f, 0.6f, 7.0f, 2, 15, null);
    	MOEMaterial.DRAGON_HELM = newLOTRMaterial("DRAGON_HELM", 700, 3.0f, 0.9f, 7.0f, 2, 15, null, null, false, true);
    	MOEMaterial.ELVEN_CIRCLET = newLOTRMaterial("ELVEN_CIRCLET", 400, 2.5f, 0.6f, 2.0f, 6, 10, null);
    	MOEMaterial.FANGORN = newLOTRMaterial("FANGORN", 450, 3.0f, 0.5f, 7.0f, 2, 15, null);
    	MOEMaterial.ENTISH = newLOTRMaterial("ENTISH", 450, 0.0f, 0.5f, 0.0f, 0, 15, null);
    	MOEMaterial.SAURON = newLOTRMaterial("SAURON", 700, 3.0f, 0.6f, 7.0f, 2, 15, null);
    	MOEMaterial.LOSSARNACH = newLOTRMaterial("LOSSARNACH", 700, 3.0f, 0.6f, 7.0f, 2, 15, null);
    	MOEMaterial.GONDOR_CROWN = newLOTRMaterial("GONDOR_CROWN", 700, 3.0f, 0.9f, 7.0f, 2, 15, null, null, false, true);
    	MOEMaterial.BALROG = newLOTRMaterial("GONDOR_CROWN", 700, 3.0f, 0.9f, 7.0f, 2, 15, null, null, false, true);
        MOEMaterial.BALROG = newLOTRMaterial("BALROG", 700, 3.0f, 0.9f, 7.0f, 2, 15, null, null, false, true);
                MOEMaterial.setup = false;
    	}
    

	
}

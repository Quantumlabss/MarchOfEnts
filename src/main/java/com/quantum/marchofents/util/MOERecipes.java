package com.quantum.marchofents.util;

import java.util.ArrayList;
import java.util.List;

import com.quantum.marchofents.init.MOEItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.*;

public class MOERecipes {
	

	
	public static void createMOEWeaponRecipes() {
		
		GameRegistry.addRecipe(new ItemStack (MOEItems.longswordArnor), "  X", " X ", "Y  ", "X", Items.iron_ingot, "Y", Items.stick);
		
		
		
	}
	
	public static void preInit() {
		createMOEWeaponRecipes();
	}
	
	

}

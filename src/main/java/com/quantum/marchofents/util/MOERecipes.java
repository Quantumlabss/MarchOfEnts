package com.quantum.marchofents.util;

import java.util.ArrayList;
import java.util.List;

import com.quantum.marchofents.init.MOEItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import lotr.common.LOTRMod;
import lotr.common.recipe.LOTRRecipes;

public class MOERecipes {
	
	public static List<IRecipe> moeArnor = new ArrayList<>();
	

	
	public static void createArnorRecipes() {
		
		GameRegistry.addShapedRecipe(new ItemStack (MOEItems.longswordArnor), "  X", " X ", "Y  ", "X", Items.iron_ingot, "Y", Items.stick);
		
		
		
	}
	public static void registerRecipes() {
		//LOTRRecipes.rangerRecipes.addAll(moeArnor);
		
	}
	
	public static boolean isIron(ItemStack itemstack) {
		return LOTRMod.isOreNameEqual(itemstack, "oreIron") || LOTRMod.isOreNameEqual(itemstack, "ingotIron");
	}
	
	public static void preInit() {
		createArnorRecipes();
		registerRecipes();
	}
	
	
	

}

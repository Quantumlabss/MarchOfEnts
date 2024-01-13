package com.quantum.marchofents.util;

import java.util.ArrayList;
import java.util.List;

import com.quantum.marchofents.init.MOEItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipesTools;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.*;
import lotr.common.LOTRMod;
import lotr.common.recipe.LOTRRecipes;


public class MOERecipes {
	
	public static List<IRecipe> moeArnor = new ArrayList<>();
	public static List<IRecipe> moeGondor = new ArrayList<>();
	public static List<IRecipe> fangorn = new ArrayList<>();
	public static List<IRecipe> moeElven = new ArrayList<>();
	public static List<IRecipe> moeGaladrim = new ArrayList<>();
	public static List<IRecipe> moeLindon = new ArrayList<>();
	
	
	
	

	
	public static void createArnorRecipes() {
		
		
		moeArnor.add(new ShapedOreRecipe (new ItemStack (MOEItems.longswordArnor), "  X", " X ", "Y  ", 'X', Items.iron_ingot, 'Y', Items.stick));
		
		
	}
	public static void createGondorRecipes() {
		//lebennin, numenorean, lossarnach?
		moeGondor.add(new ShapedOreRecipe (new ItemStack (MOEItems.lossarnachSword), " X ", " G ", " S ", 'X', LOTRMod.dwarfSteel, 'G', Items.gold_ingot, 'S', LOTRMod.blackrootStick));
		moeGondor.add(new ShapedOreRecipe (new ItemStack (MOEItems.lossarnachPoleaxe), " XG", " SX", "S  ", 'X', LOTRMod.dwarfSteel, 'G', Items.gold_ingot, 'S', LOTRMod.blackrootStick));
		moeGondor.add(new ShapedOreRecipe (new ItemStack (MOEItems.lossarnachBattleaxe), "XGX", "XSX", " S ", 'X', LOTRMod.dwarfSteel, 'G', Items.gold_ingot, 'S', LOTRMod.blackrootStick));
		moeGondor.add(new ShapedOreRecipe (new ItemStack (MOEItems.lossarnachHeavyWarhammer), "XGX", "XXX", " S ", 'X', LOTRMod.dwarfSteel, 'G', Items.gold_ingot, 'S', LOTRMod.blackrootStick));
		moeGondor.add(new ShapedOreRecipe (new ItemStack (MOEItems.lebenninHelmet), " G ", "FHF", "G G", 'G', Items.gold_ingot, 'F', Items.fish, 'H', LOTRMod.helmetGondor));
		moeGondor.add(new ShapedOreRecipe (new ItemStack (MOEItems.lebenninChestplate), "III", "FCF", "III", 'I', Items.iron_ingot, 'F', Items.fish, 'C', LOTRMod.bodyGondor));
		moeGondor.add(new ShapedOreRecipe (new ItemStack (MOEItems.lebenninLeggings), "IFI", "ILI", "FIF", 'I', Items.iron_ingot, 'F', Items.fish, 'L', LOTRMod.legsGondor));
		moeGondor.add(new ShapedOreRecipe (new ItemStack (MOEItems.lebenninBoots), "III", "FBF", "III", 'I', Items.iron_ingot, 'F', Items.fish, 'B', LOTRMod.bootsGondor));
		moeGondor.add(new ShapedOreRecipe (new ItemStack (MOEItems.pikeLebennin), " II", " B ", "S  ", 'I', Items.iron_ingot, 'B', LOTRMod.blackrootStick, 'S', Items.stick));
		moeGondor.add(new ShapedOreRecipe (new ItemStack (MOEItems.lebenninSword), " I ", " I ", " SI", 'I', Items.iron_ingot, 'S', LOTRMod.blackrootStick));
		
		
		
		
		
		
	}
	
	public static void createFangornRecipes() {
		
		fangorn.add(new ShapedOreRecipe (new ItemStack (MOEItems.fangornBow), " XY", "X Y", " XY", 'X', Items.stick, 'Y', Items.string));
		
	}
	
	public static void createElvenRecipes() {
		moeGaladrim.add(new ShapedOreRecipe (new ItemStack (MOEItems.elvenEliteHelm), "SSS", "SHS", "SSS", 'S', LOTRMod.elfSteel, 'H', LOTRMod.helmetHighElven));
		moeGaladrim.add(new ShapedOreRecipe (new ItemStack (MOEItems.elvenEliteChestplate), "SSS", "SCS", "SSS", 'S', LOTRMod.elfSteel, 'C', LOTRMod.bodyHighElven));
		moeGaladrim.add(new ShapedOreRecipe (new ItemStack (MOEItems.elvenEliteLeggings), "SSS", "SLS", "SSS", 'S', LOTRMod.elfSteel, 'L', LOTRMod.legsHighElven));
		moeGaladrim.add(new ShapedOreRecipe (new ItemStack (MOEItems.elvenEliteBoots), "SSS", "SBS", "SSS", 'S', LOTRMod.elfSteel, 'B', LOTRMod.bootsHighElven));
		GameRegistry.addShapedRecipe(new ItemStack (MOEItems.mithrilSmithingHammer), "MMM", " S ", " I ", 'M', LOTRMod.mithril, 'S', Items.stick, 'I', LOTRMod.mithrilNugget);
		//moeLindon.add(new ShapedOreRecipe (new ItemStack (MOEItems.elvenCirclet), "III", "ISI", "III", 'I', LOTRMod.elfSteel, 'S', LOTRMod.eh))
		
		
		//high elven, elven circlet? doriath? mithril smithing hammer? nargothrond? feanorian?
	}
	
	
	public static void registerRecipes() {
		LOTRRecipes.rangerRecipes.addAll(moeArnor);
		LOTRRecipes.gondorianRecipes.addAll(moeGondor);
		LOTRRecipes.highElvenRecipes.addAll(moeGaladrim);
		
		
	}
	
	public static boolean isIron(ItemStack itemstack) {
		return LOTRMod.isOreNameEqual(itemstack, "oreIron") || LOTRMod.isOreNameEqual(itemstack, "ingotIron");
	}
	
	public static void preInit() {
		createArnorRecipes();
		createGondorRecipes();
		createFangornRecipes();
		createElvenRecipes();
		registerRecipes();
	}
	
	
	

}

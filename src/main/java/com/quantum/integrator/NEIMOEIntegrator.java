package com.quantum.integrator;

import java.util.List;

import com.quantum.integrator.handler.MOEHandlerTableShaped;
import com.quantum.marchofents.util.MOERecipes;

import codechicken.nei.recipe.GuiCraftingRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;
import codechicken.nei.recipe.TemplateRecipeHandler;
import lotr.client.gui.LOTRGuiCraftingTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.crafting.IRecipe;

public class NEIMOEIntegrator {
	
	public static void registerHandler(String unlocalizedName, Class<? extends GuiContainer> guiClass, List<IRecipe> recipes) {
		registerHandler(new MOEHandlerTableShaped(recipes, guiClass, unlocalizedName));
		//registerHandler(new DRHandlerTableShapeless(recipes, guiClass, unlocalizedName));
	}

	public static void registerHandler(TemplateRecipeHandler handler) {
		GuiCraftingRecipe.craftinghandlers.add(handler);
		GuiUsageRecipe.usagehandlers.add(handler);
	}

	public static void registerRecipes() {
		//registerHandler("red_mountains", DRBlockTableRedDwarven.Gui.class, DRRecipe.redMountains);
		//registerHandler("wind_mountains", DRBlockTableWindDwarven.Gui.class, DRRecipe.windMountains);
		registerHandler("moeArnor", LOTRGuiCraftingTable.Ranger.class, MOERecipes.moeArnor);
	}

}

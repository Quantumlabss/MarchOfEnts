package com.quantum.marchofents.client.util;

import java.util.ArrayList;
import java.util.List;

import com.quantum.marchofents.init.Items;
import com.quantum.marchofents.items.ItemLebenninPike;
import com.quantum.marchofents.client.util.MOERenderLargeItem;
import com.quantum.marchofents.client.util.MOECommander;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lotr.client.render.item.LOTRRenderBow;
import lotr.client.render.item.LOTRRenderCrossbow;
import lotr.client.render.item.LOTRRenderElvenBlade;
import lotr.common.item.LOTRItemBow;
import lotr.common.item.LOTRItemCrossbow;
import lotr.common.item.LOTRItemSword;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;

public class MOERenderManager implements IResourceManagerReloadListener {
	
	public static List<MOERenderLargeItem> largeItemRenderers;
	
	public MOERenderManager() {
		largeItemRenderers = new ArrayList<>();
		IResourceManager resMgr = Minecraft.getMinecraft().getResourceManager();
		onResourceManagerReload(resMgr);
		((IReloadableResourceManager) resMgr).registerReloadListener(this);
		MinecraftForge.EVENT_BUS.register(this);
		//MinecraftForgeClient.registerItemRenderer(ItemLebenninPike, PikeRenderer);
		
	}
	
	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		largeItemRenderers.clear();
		
		for(Item item : MOECommander.getObjectFieldsOfType(Items.class, Item.class)) {
			MinecraftForgeClient.registerItemRenderer(item, null);
			MOERenderLargeItem largeItemRenderer = MOERenderLargeItem.getRenderIfLarge(item);
			if (item instanceof LOTRItemCrossbow) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderCrossbow());
			} else if (item instanceof LOTRItemBow) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderBow(largeItemRenderer));
			} else if (item instanceof LOTRItemSword && ((LOTRItemSword) item).isElvenBlade()) {
				MinecraftForgeClient.registerItemRenderer(item, new LOTRRenderElvenBlade(24.0, largeItemRenderer));
			} else if (largeItemRenderer != null) {
				MinecraftForgeClient.registerItemRenderer(item, largeItemRenderer);
			}
			if (largeItemRenderer == null) {
				continue;
			}
			largeItemRenderers.add(largeItemRenderer);
		}
		}
	
	
	
	@SubscribeEvent
	public void preTextureStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.map;
		if (map.getTextureType() == 1) {
			for (MOERenderLargeItem largeRenderer : largeItemRenderers) {
				largeRenderer.registerIcons(map);
			}
		}
	}



}

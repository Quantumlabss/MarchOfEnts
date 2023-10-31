package com.quantum.marchofents.render;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.quantum.marchofents.init.Items;


import com.quantum.marchofents.util.MOECommander;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lotr.client.render.item.LOTRRenderBow;
import lotr.client.render.item.LOTRRenderCrossbow;
import lotr.client.render.item.LOTRRenderElvenBlade;
import lotr.common.item.LOTRItemBow;
import lotr.common.item.LOTRItemCrossbow;
import lotr.common.item.LOTRItemSword;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;

public class MOERenderManager implements IResourceManagerReloadListener {
	
	private static MOERenderManager INSTANCE;
	private static List<MOERenderLargeItem> largeItemRenderers;
	
	
	public static void load() {
		largeItemRenderers = new ArrayList<MOERenderLargeItem>();
		IResourceManager resMgr = Minecraft.getMinecraft().getResourceManager();
		INSTANCE = new MOERenderManager();
		INSTANCE.onResourceManagerReload(resMgr);
		
		((IReloadableResourceManager)resMgr).registerReloadListener((IResourceManagerReloadListener)INSTANCE);
		MinecraftForge.EVENT_BUS.register((Object)INSTANCE);
	}
	
	public void onResourceManagerReload(IResourceManager resourceManager) {
		largeItemRenderers.clear();
		for (Item item : MOECommander.getAllMOEItems()) {
			MinecraftForgeClient.registerItemRenderer((Item)item, null);
			MOERenderLargeItem largeItemRenderer = MOERenderLargeItem.getRenderIfLarge(item);
			if (item instanceof LOTRItemCrossbow) {
                MinecraftForgeClient.registerItemRenderer((Item)item, (IItemRenderer)new LOTRRenderCrossbow());
            } else if (item instanceof LOTRItemBow) {
                MinecraftForgeClient.registerItemRenderer((Item)item, (IItemRenderer)new LOTRRenderBow(largeItemRenderer));
            } else if (item instanceof LOTRItemSword && ((LOTRItemSword)item).isElvenBlade()) {
                MinecraftForgeClient.registerItemRenderer((Item)item, (IItemRenderer)new LOTRRenderElvenBlade(24.0, largeItemRenderer));
            }  else if (largeItemRenderer != null) {
                MinecraftForgeClient.registerItemRenderer((Item)item, (IItemRenderer)largeItemRenderer);
            }
            if (largeItemRenderer == null) continue;
            largeItemRenderers.add(largeItemRenderer);
        	}
		}
	
	@SubscribeEvent
	public void preTextureStitch(TextureStitchEvent.Pre event) {
		TextureMap map = event.map;
		if (map.getTextureType() == 1) {
			for (MOERenderLargeItem largeRenderer : largeItemRenderers) {
				largeRenderer.registerIcons((IIconRegister)map);
			}
		}
	
	
	}
	



}

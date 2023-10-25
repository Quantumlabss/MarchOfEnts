package com.quantum.marchofents.client.util;

import java.util.ArrayList;
import java.util.List;

import com.quantum.marchofents.init.Items;
import com.quantum.marchofents.client.util.MOERenderLargeItem;
import com.quantum.marchofents.client.util.MOECommander;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
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
		
	}
	
	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		largeItemRenderers.clear();
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

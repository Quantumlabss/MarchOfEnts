package com.quantum.marchofents.proxy;





import com.quantum.marchofents.client.util.MOELongswordRenderer;
import com.quantum.marchofents.client.util.MOERenderLargeItem;
import com.quantum.marchofents.client.util.MOERenderManager;
import com.quantum.marchofents.init.Items;
import com.quantum.marchofents.items.ItemLebenninPike;
import com.quantum.marchofents.client.util.PikeRenderer;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lotr.client.LOTRItemRendererManager;
import lotr.client.render.item.LOTRRenderLargeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.MinecraftForgeClient;



public class ClientProxy extends ServerProxy implements IResourceManagerReloadListener {
	
	//private final Minecraft minecraft = Minecraft.getMinecraft();

	
	public static MOERenderManager rendererManager;
	public static LOTRItemRendererManager lotrRenderManager;
	public static MOELongswordRenderer longswordRenderer;
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
		//MinecraftForgeClient.registerItemRenderer(Items.lebenninPike, new PikeRenderer(Items.lebenninPike, "marchofents:textures/items/large-3x/", 0));
		//rendererManager = new MOERenderManager();
	//	lotrRenderManager = new LOTRItemRendererManager();
		
		LOTRItemRendererManager.load();
		//LOTRRenderLargeItem.getRendererIfLarge(Items.lebenninPike);
		MinecraftForgeClient.registerItemRenderer(Items.arnorianLongsword, longswordRenderer);
		
	}
	@Override
	public void onInit(FMLInitializationEvent event) {
		((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(new ClientProxy());
	}
	
	
	




	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		// TODO Auto-generated method stub
		
	}

}

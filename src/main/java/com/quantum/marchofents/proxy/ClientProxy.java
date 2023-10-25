package com.quantum.marchofents.proxy;





import com.quantum.marchofents.client.util.MOERenderManager;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy extends ServerProxy implements IResourceManagerReloadListener {
	
	//private final Minecraft minecraft = Minecraft.getMinecraft();
	
	public static MOERenderManager renderManager;
	
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		renderManager = new MOERenderManager();
		
		
		
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

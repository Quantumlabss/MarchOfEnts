package com.quantum.marchofents.proxy;






import com.quantum.marchofents.render.MOERenderManager;


import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy extends ServerProxy {
	
	//private final Minecraft minecraft = Minecraft.getMinecraft();

	



	//@Override

	//NetworkRegistry.instance().registerGuiHandler(this, new CommonProxy());

	//@Override
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MOERenderManager.load();

		//MinecraftForgeClient.registerItemRenderer(Items.lebenninPike, new PikeRenderer(Items.lebenninPike, "marchofents:textures/items/large-3x/", 0));
		//new MOERenderManager();

		//RenderingRegistry.registerEntityRenderingHandler(MOEEntityEnt.class, new LOTRRenderEnt());
		//largeItemRenderer = new MOERenderLargeItem(Items.pikeLebennin, "marchofents:textures/items/large2/pike_lebennin.png", 3);



	}
	@Override
	public void onInit(FMLInitializationEvent event) {

		//((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener((IResourceManagerReloadListener)this);
	}

	
	





}


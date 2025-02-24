package com.quantum.marchofents;


import com.quantum.integrator.NEIMOEIntegrator;
import com.quantum.marchofents.database.MOEMaterial;
import com.quantum.marchofents.database.MOEMiniQuestFactory;
import com.quantum.marchofents.database.MOEShields;
import com.quantum.marchofents.init.Achievements;


import com.quantum.marchofents.init.MOEBiomes;
import com.quantum.marchofents.init.MOEItems;
import com.quantum.marchofents.items.ItemFangornBanner;
import com.quantum.marchofents.proxy.ServerProxy;
import com.quantum.marchofents.render.MOERenderManager;
import com.quantum.marchofents.util.*;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = MarchOfEnts.MODID, name = MarchOfEnts.NAME, version = MarchOfEnts.VERSION, dependencies = "required-after:lotr")

public class MarchOfEnts 


{
	
	
	/* mod info vars */
	public static final String NAME = "March Of The Ents";
	public static final String MODID = "marchofents";
	public static final String VERSION = "1.0.0-B3";
    public static Logger logger = LogManager.getLogger((String)"MarchOfEnts");
	
	@SidedProxy(clientSide = "com.quantum.marchofents.proxy.ClientProxy", serverSide = "com.quantum.marchofents.proxy.ServerProxy")
	public static ServerProxy proxy;
	

	
	@Mod.Instance(value="marchofents")
	public static MarchOfEnts instance;
	
	public static MOETickHandlerServer tickHandler;
	public static MOEEventHandler eventHandler;

	//public final MOEInventory inventory = new MOEInventory();

	




	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		//NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		//init items
		//new MOERenderManager();
		MOEItems.Init();
		MOERecipes.preInit();
	//	if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			// Initialize client-only classes like MOERenderManager
		//	MOERenderManager renderManager = new MOERenderManager();
		//}

		
		ItemFangornBanner.preInit();
		eventHandler = new MOEEventHandler();
		
		
		
		proxy.preInit(event);


		
		if(MOEModChecker.hasNEI() && MOEModChecker.hasGuiContainer()) {
			NEIMOEIntegrator.registerRecipes();
		}
		
		//proxy.preInit(event);



	}
	//private static int modGuiIndex = 0;

	/** Custom GUI indices: */
	//public static final int GUI_CUSTOM_INV = modGuiIndex++;
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		tickHandler = new MOETickHandlerServer();

		
		Achievements.Init();
		MOEMaterial.setupCraftingItems();
		MOEMiniQuestFactory.onInit();
		
		MOEShields.onInit();
		MOEBiomes.onInit();
		proxy.onInit(event);

		//NetworkRegistry.INSTANCE.registerGuiHandler(this, new ServerProxy());
		MinecraftForge.EVENT_BUS.register(new MOEEventHandler());
		
		
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		//proxy.postInit(event);
		
		
	}
	
	//creative tab
	public static CreativeTabs tabMarchOfEnts = new CreativeTabs("tabMarchOfEnts") {
		
		public Item getTabIconItem() {
			//@Override
			return new ItemStack(MOEItems.nauglamir).getItem();
			
		}
	};
	
	
	
	

}

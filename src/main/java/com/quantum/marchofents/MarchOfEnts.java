package com.quantum.marchofents;


import com.quantum.integrator.NEIMOEIntegrator;
import com.quantum.marchofents.database.MOEMaterial;
import com.quantum.marchofents.database.MOEMiniQuestFactory;
import com.quantum.marchofents.database.MOEShields;
import com.quantum.marchofents.init.Achievements;


import com.quantum.marchofents.init.MOEItems;
import com.quantum.marchofents.items.ItemFangornBanner;
import com.quantum.marchofents.proxy.ServerProxy;
import com.quantum.marchofents.util.MOEEventHandler;
import com.quantum.marchofents.util.MOEModChecker;
import com.quantum.marchofents.util.MOERecipes;
import com.quantum.marchofents.util.MOETickHandlerServer;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
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
	public static final String VERSION = "1.0.0-B2";
    public static Logger logger = LogManager.getLogger((String)"MarchOfEnts");
	
	@SidedProxy(clientSide = "com.quantum.marchofents.proxy.ClientProxy", serverSide = "com.quantum.marchofents.ServerProxy")
	public static ServerProxy proxy;
	

	
	@Mod.Instance(value="marchofents")
	public static MarchOfEnts instance;
	
	public static MOETickHandlerServer tickHandler;
	public static MOEEventHandler eventHandler;

	




	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		//NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		//init items
		MOEItems.Init();
		MOERecipes.preInit();
		
		ItemFangornBanner.preInit();
		eventHandler = new MOEEventHandler();
		
		
		
		proxy.preInit(event);
		
		if(MOEModChecker.hasNEI() && MOEModChecker.hasGuiContainer()) {
			NEIMOEIntegrator.registerRecipes();
		}
		
		proxy.preInit(event);



	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		tickHandler = new MOETickHandlerServer();
		
		Achievements.Init();
		MOEMaterial.setupCraftingItems();
		MOEMiniQuestFactory.onInit();
		
		MOEShields.onInit();
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

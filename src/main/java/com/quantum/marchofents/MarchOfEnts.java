package com.quantum.marchofents;


import com.quantum.marchofents.init.Achievements;
import com.quantum.marchofents.init.Items;
import com.quantum.marchofents.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

@Mod(modid = MarchOfEnts.MODID, name = MarchOfEnts.NAME, version = MarchOfEnts.VERSION, dependencies = "required-after:lotr")

public class MarchOfEnts 


{
	
	
	/* mod info vars */
	public static final String NAME = "March Of The Ents";
	public static final String MODID = "marchofents";
	public static final String VERSION = "1.0.0-A1";
	
	@SidedProxy(clientSide = "com.quantum.marchofents.proxy.CombinedClientProxy", serverSide = "com.quantum.marchofents.DedicatedServerProxy")
	public static CommonProxy proxy;

	
	@Mod.Instance("marchofents")
	public static MarchOfEnts instance;
	
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		//init items
		Items.init();
		Achievements.Init();
		proxy.preInit();
		
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
		
		proxy.init();
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		proxy.postInit();
	}
	
	//creative tab
	public static CreativeTabs tabMarchOfEnts = new CreativeTabs("tabMarchOfEnts") {
		
		public Item getTabIconItem() {
			//@Override
			return new ItemStack(Items.arnorianLongsword).getItem();
			
		}
	};
	
	
	
	

}

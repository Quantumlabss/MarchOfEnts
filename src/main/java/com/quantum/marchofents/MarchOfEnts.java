package com.quantum.marchofents;

import com.quantum.marchofents.init.Items;

import cpw.mods.fml.common.Mod;
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
	
	
	@Mod.Instance("marchofents")
	public static MarchOfEnts instance;
	
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		//init items
		Items.init();
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		MarchOfEnts.achievementNauglamir.registerStat();
		AchievementPage.registerAchievementPage(new AchievementPage("March Of The Ents Achievements", new Achievement[] {MarchOfEnts.achievementNauglamir}));
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {}
	
	//creative tab
	public static CreativeTabs tabMarchOfEnts = new CreativeTabs("tabMarchOfEnts") {
		
		public Item getTabIconItem() {
			//@Override
			return new ItemStack(Items.arnorianLongsword).getItem();
			
		}
	};
	public static Achievement achievementNauglamir = new Achievement("achievement.nauglamir", "nauglamir", 2, 1, Items.nauglamir, MarchOfEnts.achievementNauglamir).setSpecial();
	
	
	

}

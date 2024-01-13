package com.quantum.marchofents.util;

import com.quantum.marchofents.blocks.MOECraftingTableFangorn;
import com.quantum.marchofents.init.Achievements;
import com.quantum.marchofents.init.MOEItems;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import lotr.common.LOTRLevelData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;


public class MOEEventHandler {
	
	public MOEEventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}
	

	@SubscribeEvent
	public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
		EntityPlayer player = event.player;
		World world = player.worldObj;
		if (world.isRemote) {
			return;
		}
		Container container = player.openContainer;
		//ItemStack itemstack = 
		Item item = event.crafting.getItem();
		
		if (item == MOEItems.longswordArnor) {
			LOTRLevelData.getData(player).addAchievement(Achievements.craftArnorLongsword);
		} else if (item == MOEItems.fangornBow) {
			LOTRLevelData.getData(player).addAchievement(Achievements.craftFangornBow);
		} 


	}
	
	

}

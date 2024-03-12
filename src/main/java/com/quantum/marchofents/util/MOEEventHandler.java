package com.quantum.marchofents.util;

import com.quantum.marchofents.blocks.MOECraftingTableFangorn;
import com.quantum.marchofents.init.Achievements;
import com.quantum.marchofents.init.MOEItems;
import com.quantum.marchofents.util.ExtendedPlayer;

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
import net.minecraftforge.event.entity.EntityEvent;


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

	@SubscribeEvent
	public void onEntityConstructing(EntityEvent.EntityConstructing event)
	{
		/*
		Be sure to check if the entity being constructed is the correct type
		for the extended properties you're about to add!
		The null check may not be necessary - I only use it to make sure
		properties are only registered once per entity
		*/
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null)
			// This is how extended properties are registered using our convenient method from earlier
			ExtendedPlayer.register((EntityPlayer) event.entity);
		// That will call the constructor as well as cause the init() method
		// to be called automatically

		// If you didn't make the two convenient methods from earlier, your code would be
		// much uglier:
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
			event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer) event.entity));
	}
}
	
	



package com.quantum.marchofents.util;

import com.quantum.marchofents.init.Achievements;
import com.quantum.marchofents.init.MOEItems;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class MOETickHandlerServer {
	
	public MOETickHandlerServer() {
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}
	
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		EntityPlayer player = event.player;
		//player.inventory = event.player.inventory;
		World world = player.worldObj;
		if (world.isRemote || !player.isEntityAlive() || event.phase != TickEvent.Phase.END) {
			return;
		}
		Achievements.runAchievementCheck(player);
	}
	

}

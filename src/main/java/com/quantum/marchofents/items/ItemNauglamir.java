package com.quantum.marchofents.items;

import com.quantum.marchofents.init.Achievements;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AchievementEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import lotr.common.LOTRAchievement;
import lotr.common.LOTRAchievement.Category;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRPlayerData;

public class ItemNauglamir extends Item{
	//EntityPlayer player = Minecraft.getMinecraft().thePlayer;



	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		
		((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 1));
		
		if(!LOTRLevelData.getData((EntityPlayer) entity).hasAchievement(Achievements.getNauglamir)) {
			
			LOTRLevelData.getData((EntityPlayer) entity).addAchievement(Achievements.getNauglamir);
			Achievements.getNauglamir.broadcastEarning((EntityPlayer) entity);
			
		}
	}
	

}

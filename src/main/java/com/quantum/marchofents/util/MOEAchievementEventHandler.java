package com.quantum.marchofents.util;

import com.quantum.marchofents.init.Achievements;
import com.quantum.marchofents.init.Items;

import lotr.common.LOTRLevelData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import com.quantum.marchofents.init.Achievements;

public class MOEAchievementEventHandler {
	
	public class nargothrondBattleAxe extends Items {
		public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
			
			((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 1));
			
			if(!LOTRLevelData.getData((EntityPlayer) entity).hasAchievement(Achievements.getNargothrondBattleaxe)) {
				
				LOTRLevelData.getData((EntityPlayer) entity).addAchievement(Achievements.getNargothrondBattleaxe);
				Achievements.getNauglamir.broadcastEarning((EntityPlayer) entity);
				
			}
		}
	}
	public class gondolinBattleAxe extends Items {
		public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
			
			((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 1));
			
			if(!LOTRLevelData.getData((EntityPlayer) entity).hasAchievement(Achievements.getGondolinBattleaxe)) {
				
				LOTRLevelData.getData((EntityPlayer) entity).addAchievement(Achievements.getGondolinBattleaxe);
				Achievements.getNauglamir.broadcastEarning((EntityPlayer) entity);
				
			}
		}
	}
	
			
			


}

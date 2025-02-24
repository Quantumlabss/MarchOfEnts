package com.quantum.marchofents.items;

import com.quantum.marchofents.init.Achievements;

import lotr.common.LOTRLevelData;
import lotr.common.item.LOTRItemBattleaxe;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemNargothrondBattleAxe extends LOTRItemBattleaxe {
	
	public ItemNargothrondBattleAxe(LOTRMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
	}

	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		
		
		if(!LOTRLevelData.getData((EntityPlayer) entity).hasAchievement(Achievements.getNargothrondBattleaxe)) {
			
			LOTRLevelData.getData((EntityPlayer) entity).addAchievement(Achievements.getNargothrondBattleaxe);
			Achievements.getNargothrondBattleaxe.broadcastEarning((EntityPlayer) entity);
			
		}
	}

}

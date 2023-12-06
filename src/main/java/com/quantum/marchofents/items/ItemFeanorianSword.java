package com.quantum.marchofents.items;

import com.quantum.marchofents.init.Achievements;

import lotr.common.LOTRLevelData;
import lotr.common.item.LOTRItemSword;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFeanorianSword extends LOTRItemSword {

	public ItemFeanorianSword(LOTRMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
	}
	
	
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		
		
		if(!LOTRLevelData.getData((EntityPlayer) entity).hasAchievement(Achievements.getFeanorianSword)) {
			
			LOTRLevelData.getData((EntityPlayer) entity).addAchievement(Achievements.getFeanorianSword);
			Achievements.getFeanorianSword.broadcastEarning((EntityPlayer) entity);
			
		}
	}

}

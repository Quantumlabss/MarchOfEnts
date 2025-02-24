package com.quantum.marchofents.items;

import com.quantum.marchofents.init.Achievements;

import lotr.common.LOTRLevelData;
import lotr.common.item.LOTRItemSword;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDoriathSword extends LOTRItemSword {
	
	public ItemDoriathSword(LOTRMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
	}

	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		
		
		if(!LOTRLevelData.getData((EntityPlayer) entity).hasAchievement(Achievements.getDoriathSword)) {
			
			LOTRLevelData.getData((EntityPlayer) entity).addAchievement(Achievements.getDoriathSword);
			Achievements.getDoriathSword.broadcastEarning((EntityPlayer) entity);
			
		}
	}

}

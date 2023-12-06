package com.quantum.marchofents.items;

import com.quantum.marchofents.init.Achievements;

import lotr.common.LOTRLevelData;
import lotr.common.item.LOTRItemHammer;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMithrilSmithingHammer extends LOTRItemHammer {

	public ItemMithrilSmithingHammer(LOTRMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
	}
	
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		
		
		if(!LOTRLevelData.getData((EntityPlayer) entity).hasAchievement(Achievements.getMithrilSmithingHammer)) {
			
			LOTRLevelData.getData((EntityPlayer) entity).addAchievement(Achievements.getMithrilSmithingHammer);
			Achievements.getMithrilSmithingHammer.broadcastEarning((EntityPlayer) entity);
			
		}
	}
	
	

}

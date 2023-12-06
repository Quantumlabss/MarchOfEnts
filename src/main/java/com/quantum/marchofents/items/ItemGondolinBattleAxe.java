package com.quantum.marchofents.items;

import com.quantum.marchofents.init.Achievements;

import lotr.common.LOTRLevelData;
import lotr.common.item.LOTRItemBattleaxe;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGondolinBattleAxe extends LOTRItemBattleaxe {

	public ItemGondolinBattleAxe(LOTRMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
	}
	
	
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag) {
		
		
		if(!LOTRLevelData.getData((EntityPlayer) entity).hasAchievement(Achievements.getGondolinBattleaxe)) {
			
			LOTRLevelData.getData((EntityPlayer) entity).addAchievement(Achievements.getGondolinBattleaxe);
			Achievements.getGondolinBattleaxe.broadcastEarning((EntityPlayer) entity);
			
		}
	}

}

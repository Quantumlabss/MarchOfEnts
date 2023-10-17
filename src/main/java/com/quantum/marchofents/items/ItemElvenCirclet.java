package com.quantum.marchofents.items;

import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemElvenCirclet extends LOTRItemArmor {

	public ItemElvenCirclet(LOTRMaterial gALADHRIM, int type) {
		super(gALADHRIM, type);
		// TODO Auto-generated constructor stub
	}
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return "marchofents:textures/models/armor/elven_circlet.png";
	}
	
	

}

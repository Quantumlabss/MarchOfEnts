package com.quantum.marchofents.items;

import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemLebenninArmor extends LOTRItemArmor {

	public ItemLebenninArmor(LOTRMaterial GONDOR, int slotType) {
		super(GONDOR, slotType);
		// TODO Auto-generated constructor stub
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		
		if(this.armorType == 2) {
			return "marchofents:textures/models/armor/lebennin_2.png";
		}
		return "marchofents:textures/models/armor/lebennin_1.png";
	
	}

}

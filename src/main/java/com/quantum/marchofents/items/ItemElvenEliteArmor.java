package com.quantum.marchofents.items;

import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemElvenEliteArmor extends LOTRItemArmor {

	public ItemElvenEliteArmor(LOTRMaterial hIGH_ELVEN, int type) {
		super(hIGH_ELVEN, type);
		

		// TODO Auto-generated constructor stub
	}
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if(this.armorType == 2) {
			return "marchofents:textures/models/armor/high_elven_elite_2.png";
			
		}
		return "marchofents:textures/models/armor/high_elven_elite_1.png";
		
	}

}

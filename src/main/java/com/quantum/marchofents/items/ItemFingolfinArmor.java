package com.quantum.marchofents.items;

import lotr.common.LOTRLore;
import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class ItemFingolfinArmor extends LOTRItemArmor{

	public ItemFingolfinArmor(LOTRMaterial GONDOLIN, int type) {
		// TODO Auto-generated constructor stub
		super(GONDOLIN, type);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if(this.armorType == 2) {
			return "marchofents:textures/models/armor/fingolfin_2.png";
			
		}
		return "marchofents:textures/models/armor/fingolfin_1.png";
	}
	

}

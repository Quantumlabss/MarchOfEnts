package com.quantum.marchofents.items;

import com.quantum.marchofents.util.MOECommander;

import lotr.common.item.LOTRItemArmor;
import lotr.common.item.LOTRMaterial;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class MOEItemArmor extends LOTRItemArmor {
	
	public MOEItemArmor (LOTRMaterial material, int slotType) {
		super(material, slotType);
	}
	
	public MOEItemArmor (LOTRMaterial material, int slotType, String textureSuffix) {
		super(material, slotType, textureSuffix);
	}
	
	@Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		
		
		StringBuilder texture = new StringBuilder("marchofents:textures/models/armor/").append(MOECommander.getArmorName(this));
		if(type != null) {
			texture.append("_").append(type);
			
		}
		return texture.append(".png").toString();
				
	}
	

    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final int armorSlot) {
        final ModelBiped customModel = this.getCustomModel(entityLiving, itemStack, armorSlot);
        if (customModel != null) {
            customModel.isRiding = entityLiving.isRiding();
            customModel.isSneak = entityLiving.isSneaking();
        }
        return customModel;
    }
    
    public ModelBiped getCustomModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final int armorSlot) {
        return null;
    }
	

}

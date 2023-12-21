package com.quantum.marchofents.items;

import com.quantum.marchofents.database.MOEMaterial;
import com.quantum.marchofents.render.model.MOEModelSauronChestplate;
import com.quantum.marchofents.render.model.MOEModelSauronHelmet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ItemSauronChestplate extends MOEItemArmor {
@SideOnly(Side.CLIENT)

	private ModelBiped model;

	public ItemSauronChestplate() {
		super(MOEMaterial.SAURON, 1, "chestplate");
	}
	
	
	@SideOnly(Side.CLIENT)
	@Override
    public ModelBiped getCustomModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final int armorSlot) {
        if (armorSlot == 1) {
            if (this.model == null) {
                this.model = (ModelBiped)new MOEModelSauronChestplate(1.0f);
            	
            }
            return this.model;
        }
        return null;
    }




}

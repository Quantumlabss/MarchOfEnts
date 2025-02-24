package com.quantum.marchofents.items;

import com.quantum.marchofents.database.MOEMaterial;
import com.quantum.marchofents.render.model.MOEModelElvenEliteHelm;
import com.quantum.marchofents.render.model.MOEModelLebenninHelmet;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ItemElvenEliteHelm extends MOEItemArmor {

    @SideOnly(Side.CLIENT)

    private ModelBiped model;

    public ItemElvenEliteHelm() {
        super(MOEMaterial.HIGH_ELVEN_ELITE, 0, "helmet");

    }

    @SideOnly(Side.CLIENT)
    @Override
    public ModelBiped getCustomModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final int armorSlot) {
        if (armorSlot == 0) {
            if (this.model == null) {
                this.model = (ModelBiped)new MOEModelElvenEliteHelm(1.0f);
            }
            return this.model;
        }
        return null;
    }
}

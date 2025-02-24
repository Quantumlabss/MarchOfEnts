//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "/home/alex/Downloads/mcp908"!

//Decompiled by Procyon!

package com.quantum.marchofents.items;


import lotr.common.item.*;
import net.minecraft.client.model.*;

import com.quantum.marchofents.MarchOfEnts;
import com.quantum.marchofents.database.MOEMaterial;

import cpw.mods.fml.relauncher.*;

import lotr.common.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import lotr.client.model.*;
import net.minecraft.entity.*;

public class ItemDragonHelm extends MOEItemArmor implements LOTRStoryItem
{
    @SideOnly(Side.CLIENT)
    private ModelBiped model;
    
    public ItemDragonHelm() {
        super(MOEMaterial.DRAGON_HELM, 0);
   
        this.setCreativeTab(MarchOfEnts.tabMarchOfEnts);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public ModelBiped getArmorModel(final EntityLivingBase entityLiving, final ItemStack itemStack, final int armorSlot) {
        if (armorSlot == 0) {
            if (this.model == null) {
                this.model = (ModelBiped)new LOTRModelUmbarHelmet(1.0f);
            }
            return this.model;
        }
        return super.getArmorModel(entityLiving, itemStack, armorSlot);
    }
    
    @Override
    public String getArmorTexture(final ItemStack itemstack, final Entity entity, final int slot, final String type) {
        if (slot == 0) {
            return "marchofents:textures/models/armor/dragon_helm.png";
        }
        return super.getArmorTexture(itemstack, entity, slot, type);
    }
}

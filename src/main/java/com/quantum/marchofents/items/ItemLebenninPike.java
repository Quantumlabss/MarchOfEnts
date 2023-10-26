package com.quantum.marchofents.items;

import com.quantum.marchofents.MarchOfEnts;

import lotr.common.item.LOTRItemPike;
import lotr.common.item.LOTRMaterial;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
//import lotr.client.render.item.LOTRRenderLargeItem;

public class ItemLebenninPike extends LOTRItemPike {
	
	//Minecraft.getMinecraft.getRenderItem

	public ItemLebenninPike(LOTRMaterial pELARGIR) {
		super(pELARGIR);
		this.setTextureName("marchofents:pike_lebennin");
		// TODO Auto-generated constructor stub
	}
	
	public void registerIcons(IIconRegister iconRegister, ItemStack item) {
		itemIcon = iconRegister.registerIcon(MarchOfEnts.MODID + ":" + getUnlocalizedName(item));
	}
	@Override
	public IIcon getIconIndex(ItemStack item) {
		return this.getIcon(item,0);
	}
	//public static ResourceLocation res = new ResourceLocation("marchofents:pike_lebennin", "inventory");
	


}

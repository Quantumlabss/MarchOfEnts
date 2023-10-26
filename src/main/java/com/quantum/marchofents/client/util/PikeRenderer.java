package com.quantum.marchofents.client.util;

import org.lwjgl.opengl.GL11;

import com.quantum.marchofents.items.ItemLebenninPike;

import lotr.client.render.item.LOTRRenderLargeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class PikeRenderer extends LOTRRenderLargeItem {
	
	public final float largeIconScale;
	

	public PikeRenderer(Item item, String dir, float f) {
		super(item, dir, f);
		largeIconScale = f;
		// TODO Auto-generated constructor stub
	}
	
	public static ResourceLocation getLargeTexturePath(Item item, String folder) {
		return new ResourceLocation("marchofents:textures/items/large-3x/pike_lebennin.png");
	}

	


	
	


	}



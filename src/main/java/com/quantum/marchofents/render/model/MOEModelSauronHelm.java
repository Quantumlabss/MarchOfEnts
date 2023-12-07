package com.quantum.marchofents.render.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


public class MOEModelSauronHelm extends LOTRModelBiped {
	private final ModelRenderer head;
	
	public MOEModelSauronHelm() {
		this(0.0f);
	}

	public MOEModelSauronHelm(final float f) {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -7.0F, -4.0F, 8, 8, 8, 0.75F));
		head.cubeList.add(new ModelBox(head, 32, 0, -4.0F, -7.0F, -4.0F, 8, 8, 8, 1.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, -1.0F, -16.75F, -4.25F, 2, 9, 2, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 2.5F, -16.75F, -0.25F, 2, 9, 2, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, -4.5F, -16.75F, -0.25F, 2, 9, 2, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, -1.0F, -16.75F, 2.75F, 2, 9, 2, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 2.0F, -14.75F, -4.25F, 2, 7, 2, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -14.75F, -4.25F, 2, 7, 2, 0.0F));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
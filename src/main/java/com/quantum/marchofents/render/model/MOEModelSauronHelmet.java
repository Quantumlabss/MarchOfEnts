package com.quantum.marchofents.render.model;

import lotr.client.model.*;
import net.minecraft.client.model.*;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
public class MOEModelSauronHelmet extends LOTRModelBiped {
	
	private ModelRenderer spikeFCenter;
	private ModelRenderer spikeFLeft;
	private ModelRenderer spikeFRight;
	private ModelRenderer spikeRight;
	private ModelRenderer spikeLeft;
	private ModelRenderer spikeBack;
	
	
	public MOEModelSauronHelmet() {
		this(0.0f);
	}
	
	
	public MOEModelSauronHelmet(final float f) {
		super(f);
		textureWidth = 64;
		textureHeight = 32;
		
		(this.bipedHead = new ModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
        this.bipedHead.setTextureOffset(32, 0).addBox(-0.5f, -9.0f, -3.5f, 1, 1, 7, f);
        (this.spikeFCenter = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0F, -16.75F, -4.25F, 2, 9, 2, 0.0F);
        (this.spikeFLeft = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0F, -14.75F, -4.25F, 2, 7, 2, 0.0F);
        (this.spikeFRight = new ModelRenderer((ModelBase)this, 0, 0)).addBox(2.0F, -14.75F, -4.25F, 2, 7, 2, 0.0F);
        (this.spikeRight = new ModelRenderer((ModelBase)this, 0, 0)).addBox(2.5F, -16.75F, -0.25F, 2, 9, 2, 0.0F);
        (this.spikeLeft = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.5F, -16.75F, -0.25F, 2, 9, 2, 0.0F);
        (this.spikeBack = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0F, -16.75F, 2.75F, 2, 9, 2, 0.0F);
        this.bipedHead.addChild(this.spikeFCenter);
        this.bipedHead.addChild(this.spikeFLeft);
        this.bipedHead.addChild(this.spikeFRight);
        this.bipedHead.addChild(this.spikeLeft);
        this.bipedHead.addChild(this.spikeRight);
        this.bipedHead.addChild(this.spikeBack);
        this.bipedHeadwear.cubeList.clear();
        this.bipedBody.cubeList.clear();
        this.bipedRightArm.cubeList.clear();
        this.bipedLeftArm.cubeList.clear();
        this.bipedRightLeg.cubeList.clear();
        this.bipedLeftLeg.cubeList.clear();
	}
	
    @Override
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

    }

}

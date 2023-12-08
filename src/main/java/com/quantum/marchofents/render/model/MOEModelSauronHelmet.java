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
		
		(this.bipedHead = new ModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
        this.bipedHead.setTextureOffset(32, 0).addBox(-0.5f, -9.0f, -3.5f, 1, 1, 7, f);
       // (this.spikeFCenter = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-4.0F, -7.0F, -4.0F, 8, 8, 8, 0.75F);
       // this.spikeFCenter.setTextureOffset(20, 16).addBox(-3.5f - f, -5.0f, 1.9f + f, 0, 6, 8, 0.0f);
        this.bipedHead.addBox(0, 0, -4.0F, 8, 8, 8, 0.75F);
		this.bipedHead.addBox(32, 0, -4.0F, 8, 8, 8, 1.0F);
		this.bipedHead.addBox(0, 0, -1.0F, 2, 9, 2, 0.0F);
		this.bipedHead.addBox(0, 0, 2.5F, 2, 9, 2, 0.0F);
		this.bipedHead.addBox(0, 0, -4.5F, 2, 9, 2, 0.0F);
		this.bipedHead.addBox(0, 0, -1.0F, 2, 9, 2, 0.0F);
		this.bipedHead.addBox(0, 0, 2.0F, 2, 7, 2, 0.0F);
		this.bipedHead.addBox(0, 0, -4.0F, 2, 7, 2, 0.0F);
      //  this.bipedHead.addChild(this.spikeFCenter);
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

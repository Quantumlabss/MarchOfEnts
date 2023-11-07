package com.quantum.marchofents.render.model;

import com.quantum.marchofents.render.MOEHelmetModelBase;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MOEModelLebenninHelmet extends LOTRModelBiped {
	
	private ModelRenderer wingLeft;
	private ModelRenderer wingRight;
	
	public MOEModelLebenninHelmet() {
		this(0.0f);
	}
	
	public MOEModelLebenninHelmet(final float f) {
		super(f);
		(this.bipedHead = new ModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
        this.bipedHead.setTextureOffset(32, 0).addBox(-0.5f, -9.0f, -3.5f, 1, 1, 7, f);
        (this.wingRight = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-4.0f - f, -6.0f, 1.0f + f, 1, 1, 9, 0.0f);
        this.wingRight.setTextureOffset(20, 16).addBox(-3.5f - f, -5.0f, 1.9f + f, 0, 6, 8, 0.0f);
        this.wingLeft = new ModelRenderer((ModelBase)this, 0, 16);
        this.wingLeft.mirror = true;
        this.wingLeft.addBox(3.0f + f, -6.0f, 1.0f + f, 1, 1, 9, 0.0f);
        this.wingLeft.setTextureOffset(20, 16).addBox(3.5f + f, -5.0f, 1.9f + f, 0, 6, 8, 0.0f);
        this.bipedHead.addChild(this.wingRight);
        this.bipedHead.addChild(this.wingLeft);
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
        final float wingYaw = (float)Math.toRadians(-25.0);
        final float wingPitch = (float)Math.toRadians(20.0);
        this.wingRight.rotateAngleY = wingYaw;
        this.wingLeft.rotateAngleY = -wingYaw;
        this.wingRight.rotateAngleX = wingPitch;
        this.wingLeft.rotateAngleX = wingPitch;
    }
}



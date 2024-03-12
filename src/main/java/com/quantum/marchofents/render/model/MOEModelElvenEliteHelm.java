package com.quantum.marchofents.render.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MOEModelElvenEliteHelm extends LOTRModelBiped {

    private ModelRenderer wingLeft;
    private ModelRenderer wingRight;
    private ModelRenderer spikeFront;
    private ModelRenderer spikeCenter;
    private ModelRenderer spikeBack;
    private ModelRenderer wingTopLeft;
    private ModelRenderer wingTopRight;
    private ModelRenderer wingBottomLeft;
    private ModelRenderer wingBottomRight;
    private ModelRenderer wingTipLeft;
    private ModelRenderer wingTipRight;

    public MOEModelElvenEliteHelm() {
        this(0.0f);
    }

    public MOEModelElvenEliteHelm(final float f) {
        super(f);
        (this.bipedHead = new ModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedHead.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);

        (this.spikeBack = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-1.0F, -13.0F, 2.0F, 2, 5, 2, f);

        (this.spikeCenter = new ModelRenderer((ModelBase)this, 20, 16)).addBox(-1.0F, -12.0F, -1.0F, 2, 4, 2, f);

        (this.spikeFront = new ModelRenderer((ModelBase)this, 24, 0)).addBox(-1.0F, -11.0F, -4.0F, 2, 3, 2, f);

        (this.wingRight = new ModelRenderer((ModelBase)this, 10, 16)).addBox(-6.601F, -11.4F, -1.0F, 3, 8, 2, f);

        (this.wingLeft = new ModelRenderer((ModelBase)this, 0, 16)).addBox(3.399F, -11.4F, -1.0F, 3, 8, 2, f);

        (this.wingTopLeft = new ModelRenderer((ModelBase)this, 0, 26)).addBox(2.9F, -14.4F, -1.0F, 2, 3, 2, f);
        (this.wingTopRight = new ModelRenderer((ModelBase)this, 8, 26)).addBox(-5.1F, -14.4F, -1.0F, 2, 3, 2, f);
        (this.wingTipLeft = new ModelRenderer((ModelBase)this, 24, 26)).addBox(2.9F, -16.4F, -1.0F, 1, 2, 2, f);
        (this.wingTipRight = new ModelRenderer((ModelBase)this, 28, 16)).addBox(-4.1F, -16.4F, -1.0F, 1, 2, 2, f);
        (this.wingBottomLeft = new ModelRenderer((ModelBase)this, 20, 22)).addBox(2.4F, -3.4F, -1.0F, 3, 2, 2, f);
        (this.wingBottomRight = new ModelRenderer((ModelBase)this, 16, 26)).addBox(-5.6F, -3.4F, -1.0F, 2, 2, 2, f);


        this.bipedHead.addChild(this.spikeBack);
        this.bipedHead.addChild(this.spikeCenter);
        this.bipedHead.addChild(this.spikeFront);
        this.bipedHead.addChild(this.wingRight);
        this.bipedHead.addChild(this.wingLeft);
        this.bipedHead.addChild(this.wingTipLeft);
        this.bipedHead.addChild(this.wingBottomLeft);
        this.bipedHead.addChild(this.wingTopLeft);
        this.bipedHead.addChild(this.wingTipRight);
        this.bipedHead.addChild(this.wingTopRight);
        this.bipedHead.addChild(this.wingBottomRight);
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

package com.quantum.marchofents.render.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MOEModelSauronChestplate extends LOTRModelBiped {
	
	
	public MOEModelSauronChestplate() {
		this(0.0f);
	}
	
	
	public MOEModelSauronChestplate(final float f) {
		super(f);
		textureWidth = 32;
		textureHeight = 32;
		(this.bipedBody = new ModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bipedBody.addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8, f);
		
		
		
	}
	
	
	@Override
    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

    }

}

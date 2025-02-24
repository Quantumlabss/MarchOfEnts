package com.quantum.marchofents.render.model;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MOEModelGondorCrown extends LOTRModelBiped {
	
	
	private ModelRenderer group;
	
	public MOEModelGondorCrown() {
				this(0.0f);

			}
			
	public MOEModelGondorCrown(final float f) {
				super(f);
				(this.bipedHead = new ModelRenderer((ModelBase)this, 0, 0)).setRotationPoint(0.0f, 0.0f, 0.0f);

		        
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

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
		        this.bipedHead.addBox(-4.0f, -8.0f, -4.0f, 14, 4, 14, f);
		        this.bipedHead.setTextureOffset(32, 0).addBox(-0.5f, -9.0f, -3.5f, 1, 1, 7, f);
		       // this.bipedHead.addBox(-1.0F, 6.0F, 7.0F, 2, 10, 1, 0.0F);
		      //  this.bipedHead.addBox(1.0F, 8.0F, 7.0F, 2, 7, 1, 0.0F);
		      //  this.bipedHead.addBox(-3.0F, 8.0F, 7.0F, 2, 7, 1, 0.0F);
		      //  this.bipedHead.addBox(-1.0F, 6.0F, -8.0F, 2, 10, 1, 0.0F);
		      //  this.bipedHead.addBox(1.0F, 8.0F, -8.0F, 2, 7, 1, 0.0F);
		      //  this.bipedHead.addBox(-3.0F, 8.0F, -8.0F, 2, 7, 1, 0.0F);
		        //this.bipedHead.addBox(-8.0F, 7.0F, -1.0F, 1, 9, 2, 0.0F);
		       // this.bipedHead.addBox(-8.0F, 9.0F, -3.0F, 1, 6, 2, 0.0F);
		      //  this.bipedHead.addBox(-8.0F, 9.0F, 1.0F, 1, 6, 2, 0.0F);
		      //  this.bipedHead.addBox(7.0F, 7.0F, -1.0F, 1, 9, 2, 0.0F);
		      //  this.bipedHead.addBox(7.0F, 9.0F, -3.0F, 1, 6, 2, 0.0F);
		      //  this.bipedHead.addBox(7.0F, 9.0F, 1.0F, 1, 6, 2, 0.0F);
		      //  this.bipedHead.addBox(-1.0F, 9.0F, -9.0F, 2, 1, 1, 0.0F);
		      //  this.bipedHead.addBox(-2.0F, 10.0F, -9.0F, 4, 4, 1, 0.0F);
		      //  this.bipedHead.addBox(-1.0F, 14.0F, -9.0F, 2, 1, 1, 0.0F);
		     //   this.bipedHead.addBox(-1.0F, 14.0F, 8.0F, 2, 1, 1, 0.0F);
		       // this.bipedHead.addBox(-2.0F, 10.0F, 8.0F, 4, 4, 1, 0.0F);
		      //  this.bipedHead.addBox(-1.0F, 9.0F, 8.0F, 2, 1, 1, 0.0F);
		      //  this.bipedHead.addBox(5.0F, 10.0F, -8.0F, 3, 4, 3, 0.0F);
		     //   this.bipedHead.addBox(-8.0F, 10.0F, 5.0F, 3, 4, 3, 0.0F);
		      //  this.bipedHead.addBox(5.0F, 10.0F, 5.0F, 3, 4, 3, 0.0F);
		      //  this.bipedHead.addBox(-8.0F, 10.0F, -8.0F, 3, 4, 3, 0.0F);
		      //  this.bipedHead.addBox(6.0F, 9.0F, -8.0F, 2, 1, 2, 0.0F);
		     //   this.bipedHead.addBox(6.0F, 9.0F, 6.0F, 2, 1, 2, 0.0F);
		     //   this.bipedHead.addBox(-8.0F, 9.0F, 6.0F, 2, 1, 2, 0.0F);
		     //   this.bipedHead.addBox(6.0F, 14.0F, -8.0F, 2, 1, 2, 0.0F);
		     //   this.bipedHead.addBox(-8.0F, 14.0F, 6.0F, 2, 1, 2, 0.0F);
		     //   this.bipedHead.addBox(6.0F, 14.0F, 6.0F, 2, 1, 2, 0.0F);
		     //   this.bipedHead.addBox(-8.0F, 14.0F, -8.0F, 2, 1, 2, 0.0F);
		      
		     // group.cubeList.add(new ModelBox(group, 0, 0, -6.9999F, 9.9999F, -7.0001F, 14, 4, 14, 0.0F));
		        group = new ModelRenderer(this);
		        group.setRotationPoint(0.0F, 0.0F, 0.0F);
		        group.cubeList.add(new ModelBox(group, 6, 18, -1.0F, 6.0F, 7.0F, 2, 10, 1, 0.0F));
				group.cubeList.add(new ModelBox(group, 18, 33, 1.0F, 8.0F, 7.0F, 2, 7, 1, 0.0F));
				group.cubeList.add(new ModelBox(group, 12, 33, -3.0F, 8.0F, 7.0F, 2, 7, 1, 0.0F));
				group.cubeList.add(new ModelBox(group, 0, 18, -1.0F, 6.0F, -8.0F, 2, 10, 1, 0.0F));
				group.cubeList.add(new ModelBox(group, 30, 25, 1.0F, 8.0F, -8.0F, 2, 7, 1, 0.0F));
				group.cubeList.add(new ModelBox(group, 6, 29, -3.0F, 8.0F, -8.0F, 2, 7, 1, 0.0F));
				group.cubeList.add(new ModelBox(group, 6, 0, -8.0F, 7.0F, -1.0F, 1, 9, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 0, 29, -8.0F, 9.0F, -3.0F, 1, 6, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 24, 25, -8.0F, 9.0F, 1.0F, 1, 6, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 0, 0, 7.0F, 7.0F, -1.0F, 1, 9, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 18, 25, 7.0F, 9.0F, -3.0F, 1, 6, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 12, 25, 7.0F, 9.0F, 1.0F, 1, 6, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 25, 38, -1.0F, 9.0F, -9.0F, 2, 1, 1, 0.0F));
				group.cubeList.add(new ModelBox(group, 36, 29, -2.0F, 10.0F, -9.0F, 4, 4, 1, 0.0F));
				group.cubeList.add(new ModelBox(group, 0, 38, -1.0F, 14.0F, -9.0F, 2, 1, 1, 0.0F));
				group.cubeList.add(new ModelBox(group, 37, 25, -1.0F, 14.0F, 8.0F, 2, 1, 1, 0.0F));
				group.cubeList.add(new ModelBox(group, 0, 43, -2.0F, 10.0F, 8.0F, 4, 4, 1, 0.0F));
				group.cubeList.add(new ModelBox(group, 0, 50, -1.0F, 9.0F, 8.0F, 2, 1, 1, 0.0F));
				group.cubeList.add(new ModelBox(group, 52, 57, 5.0F, 10.0F, -8.0F, 3, 4, 3, 0.0F));
				group.cubeList.add(new ModelBox(group, 52, 57, -8.0F, 10.0F, 5.0F, 3, 4, 3, 0.0F));
				group.cubeList.add(new ModelBox(group, 52, 57, 5.0F, 10.0F, 5.0F, 3, 4, 3, 0.0F));
				group.cubeList.add(new ModelBox(group, 52, 57, -8.0F, 10.0F, -8.0F, 3, 4, 3, 0.0F));
				group.cubeList.add(new ModelBox(group, 56, 0, 6.0F, 9.0F, -8.0F, 2, 1, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 56, 0, 6.0F, 9.0F, 6.0F, 2, 1, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 56, 0, -8.0F, 9.0F, 6.0F, 2, 1, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 56, 0, -8.0F, 9.0F, -8.0F, 2, 1, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 56, 7, 6.0F, 14.0F, -8.0F, 2, 1, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 56, 7, -8.0F, 14.0F, 6.0F, 2, 1, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 56, 7, 6.0F, 14.0F, 6.0F, 2, 1, 2, 0.0F));
				group.cubeList.add(new ModelBox(group, 56, 7, -8.0F, 14.0F, -8.0F, 2, 1, 2, 0.0F));
		        
		       // this.bipedHead.cubeList.addAll(group);
				this.bipedHead.addChild(group);
		        
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

package com.quantum.marchofents.render;

import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import com.quantum.marchofents.init.MOEItems;
import com.quantum.marchofents.render.model.MOEModelLebenninHelmet;

import lotr.client.model.LOTRModelBiped;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

public abstract class MOEHelmetModelBase extends LOTRModelBiped {
	protected final float scaleOffset;
	
	public MOEHelmetModelBase(final float scaleOffset) {
		this.scaleOffset = scaleOffset;
	}
	
	public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5 ) {
		 final ModelRenderer overlayModelRenderer = this.getHelmetOverlayModelRenderer();
	        this.bipedHead = this.getHelmetModelRenderer();
	        if (overlayModelRenderer != null) {
	            this.bipedHeadwear = overlayModelRenderer;
	        }
	        this.bipedHead.showModel = true;
	        this.bipedHeadwear.showModel = this.showOverlay();
	        this.bipedBody.showModel = false;
	        this.bipedRightArm.showModel = false;
	        this.bipedLeftArm.showModel = false;
	        this.bipedRightLeg.showModel = false;
	        this.bipedLeftLeg.showModel = false;
	        this.bipedEars.showModel = false;
	        this.bipedCloak.showModel = false;
	        GL11.glPushMatrix();
	        GL11.glScalef(1.0f + this.scaleOffset / 4.0f, 1.0f + this.scaleOffset / 4.0f, 1.0f + this.scaleOffset / 4.0f);
	        super.render(entity, f, f1, f2, f3, f4, f5);
	        GL11.glPopMatrix();
	}
	
	public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    protected abstract ModelRenderer getHelmetModelRenderer();
    
    protected ModelRenderer getHelmetOverlayModelRenderer() {
        return null;
    }
    
    protected boolean showOverlay() {
        return false;
    }
	


}

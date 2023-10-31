package com.quantum.marchofents.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

public class MOELongswordRenderer implements IItemRenderer {


@Override
public boolean handleRenderType(ItemStack item, ItemRenderType type) {
	switch(type){
	case ENTITY:
	case EQUIPPED:
	case EQUIPPED_FIRST_PERSON:
		return true;
	default: return false;
	}

}

@Override
public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
	switch(type){
	case ENTITY:
	case EQUIPPED:
	case EQUIPPED_FIRST_PERSON:
		return true;

	default: return false;
	//return false;
	}
}

@Override
public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

	switch(type){
	case ENTITY:
	case EQUIPPED:
	case EQUIPPED_FIRST_PERSON:

		GL11.glPushMatrix();

		//IIcon icon = item.getItem().getIcon(item, 0);
		//Tessellator tessellator = Tessellator.instance;

		GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f); //X
		GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f); //Y
		GL11.glRotatef(0.0f, 0.0f, 0.0f, 0.0f); //Z
		GL11.glTranslatef(0.0f, 0.0f, 0.0f);
		GL11.glScalef(1.50f, 1.5f, 1.5f);

		IIcon icon = item.getItem().getIcon(item, 0);
		Tessellator tessellator = Tessellator.instance;

		ItemRenderer.renderItemIn2D(tessellator, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625F);

		GL11.glPopMatrix();
	default:
		break;
	}

}

}

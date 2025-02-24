package com.quantum.marchofents.render;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.CaseFormat;
import com.quantum.marchofents.MarchOfEnts;

import cpw.mods.fml.common.registry.GameRegistry;

import lotr.client.render.item.LOTRRenderLargeItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResource;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import java.util.Map.Entry;

import org.lwjgl.opengl.GL11;

public class MOERenderLargeItem extends LOTRRenderLargeItem {
	
	private static Map<String, Float> sizeFolders = new HashMap<String, Float>();
	private final Item theItem;
	private final String folderName;
	private final float largeIconScale;
	private IIcon largeIcon;
	private List<LOTRRenderLargeItem.ExtraLargeIconToken> extraTokens = new ArrayList<LOTRRenderLargeItem.ExtraLargeIconToken>();
	
	
	private static ResourceLocation getLargeTexturePath(Item item, String folder) {
		String itemIconString = item.getUnlocalizedName().substring("item.".length());
		itemIconString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemIconString);
		//GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor((Item) item);
		
		//if (UID == null) {
	//		MarchOfEnts.logger.fatal("Tried registering a item which doesn't have a unique identifier.");
	//	}
		//String modID = StringUtils.isNullOrEmpty((String)UID.modId) ? "minecraft" : UID.modId;
		//String modID = "marchofents";
		return new ResourceLocation("marchofents:textures/items/" + folder + "/" + itemIconString + ".png");
	}
	
	public static MOERenderLargeItem getRenderIfLarge(Item item) {
		for (String folder : sizeFolders.keySet()) {
			float iconScale = sizeFolders.get(folder).floatValue();
			try {
				ResourceLocation resLoc = MOERenderLargeItem.getLargeTexturePath(item, folder);
				IResource res = Minecraft.getMinecraft().getResourceManager().getResource(resLoc);
				if(res == null) continue;
				return new MOERenderLargeItem(item, folder, iconScale);
			}
			catch (IOException iOEcxeption) {
				
			}
		}
		return null;
	}
	
	
	public MOERenderLargeItem(Item item, String dir, float f) {
		super(item, dir, f);
		this.theItem = item;
		this.folderName = dir;
		this.largeIconScale = f;
	}
	
	@Override
	public LOTRRenderLargeItem.ExtraLargeIconToken extraIcon(String name) {
		LOTRRenderLargeItem.ExtraLargeIconToken token = new LOTRRenderLargeItem.ExtraLargeIconToken(name);
		this.extraTokens.add(token);
		return token;
		}
	
	
	@Override
	public void registerIcons(IIconRegister register) {
		this.largeIcon = this.registerLargeIcon(register, null);
		for(LOTRRenderLargeItem.ExtraLargeIconToken token : this.extraTokens) {
			token.icon = this.registerLargeIcon(register, token.name);
		}
	}
	
	
	private IIcon registerLargeIcon(IIconRegister register, String extra) {
		String itemName = this.theItem.getUnlocalizedName().substring("item.".length());
		itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemName);
		//GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor((Item)this.theItem);
		
		//if(UID == null) {
			//MarchOfEnts.logger.fatal("Tried registering a item which doesn't have a unique identifier.");
			
		//}
		//String modID = (StringUtils.isNullOrEmpty((String)UID.modId) ? "minecraft" : UID.modId) + ":";
		//String modID = "marchofents";
		String path = "marchofents:" + this.folderName + "/" + itemName;
		if(!StringUtils.isNullOrEmpty((String) extra)) {
			path = path + "_" + extra;
		}
		return register.registerIcon(path);
				
	}
	
	private void doTransformations() {
        GL11.glTranslatef((float)(-(this.largeIconScale - 1.0f) / 2.0f), (float)(-(this.largeIconScale - 1.0f) / 2.0f), (float)0.0f);
        GL11.glScalef((float)this.largeIconScale, (float)this.largeIconScale, (float)1.0f);
	}
	
	@Override
	public void renderLargeItem() {
		this.renderLargeItem(this.largeIcon);
	}
	
	private void renderLargeItem(IIcon icon) {
		this.doTransformations();
		Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationItemsTexture);
		GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
		Tessellator tess = Tessellator.instance;
		ItemRenderer.renderItemIn2D(tess, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625f);
	}
	
	static {
		sizeFolders.put("large", Float.valueOf(2.0f));
		sizeFolders.put("large2", Float.valueOf(3.0f));
	}
	
	

}

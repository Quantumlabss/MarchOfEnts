package com.quantum.marchofents.render;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.CaseFormat;


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
	
	public static Map<String, Float> sizeFolders = new HashMap<String, Float>();
	
	static {
		sizeFolders.put("large", 2.0f);
		sizeFolders.put("large2", 3.0f);
	}
	
	private final Item theItem;
	private final String folderName;
	private final float largeIconScale;
	private List<LOTRRenderLargeItem.ExtraLargeIconToken> extraTokens = new ArrayList<LOTRRenderLargeItem.ExtraLargeIconToken>();
	private IIcon largeIcon;
	
	public MOERenderLargeItem(Item item, String dir, float f) {
		super(item, dir, f);
		this.theItem = item;
		this.folderName = dir;
		this.largeIconScale = f;
	}
	
	
	private static ResourceLocation getLargeTexturePath(Item item, String folder) {
		  String itemIconString = item.getUnlocalizedName().substring("item.".length());
	        itemIconString = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemIconString);
	        GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor((Item)item);
	        if (UID == null) {
	            //MarchOfEnts.logger.fatal("Tried registering a item which doesn't have a unique identifier.");
	        }
	        String modID = StringUtils.isNullOrEmpty((String)UID.modId) ? "minecraft" : UID.modId;
	        return new ResourceLocation(modID, "textures/items/" + folder + "/" + itemIconString + ".png");

	}
	
	public static MOERenderLargeItem getRenderIfLarge(Item item) {
		for(Entry<String, Float> folder : sizeFolders.entrySet()) {
			float iconScale = folder.getValue();
			try {
				ResourceLocation resLoc = MOERenderLargeItem.getLargeTexturePath(item, folder.getKey());
				IResource res = Minecraft.getMinecraft().getResourceManager().getResource(resLoc);
				if (res == null) {
					continue;
				}
				return new MOERenderLargeItem(item, folder.getKey(), iconScale);
				
			} catch (IOException ignored) {
				
			}
			
		}
		return null;
	}
	
	private void doTransformations() {
		GL11.glTranslatef(-(largeIconScale - 1.0f) / 2.0f, -(largeIconScale - 1.0f) / 2.0f, 0.0f);
		GL11.glScalef(largeIconScale, largeIconScale, 1.0f);
	}
	@Override
	public LOTRRenderLargeItem.ExtraLargeIconToken extraIcon(String name) {
		LOTRRenderLargeItem.ExtraLargeIconToken token = new LOTRRenderLargeItem.ExtraLargeIconToken(name);
		this.extraTokens.add(token);
		return token;
	}

	@Override
	public void registerIcons(IIconRegister register) {
		largeIcon = registerLargeIcon(register, null);
		for (LOTRRenderLargeItem.ExtraLargeIconToken token : extraTokens) {
			token.icon = registerLargeIcon(register, token.name);
		}
	}

	private IIcon registerLargeIcon(IIconRegister register, String extra) {
		String itemName = this.theItem.getUnlocalizedName().substring("item.".length());
		//String itemName = theItem.getUnlocalizedName().substring(5);
		itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, itemName);
		//String modID = ("marchofents:");
		GameRegistry.UniqueIdentifier UID = GameRegistry.findUniqueIdentifierFor(this.theItem);
		String modID = (StringUtils.isNullOrEmpty(UID.modId) ? "minecraft" : UID.modId) + ":";
		String path = modID + this.folderName + "/" + itemName;
		//StringBuilder path = new StringBuilder().append(modID).append(folderName).append("/").append(itemName);
		if (!StringUtils.isNullOrEmpty(extra)) {
			//path.append("_").append(extra);
			path = path + "_" + extra;
		}
		
		return register.registerIcon(path);
		
	}

	@Override
	public void renderLargeItem() {
		renderLargeItem(largeIcon);
	}

	private void renderLargeItem(IIcon icon) {
		doTransformations();
		Minecraft.getMinecraft().getTextureManager().bindTexture(TextureMap.locationItemsTexture);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		Tessellator tess = Tessellator.instance;
		ItemRenderer.renderItemIn2D(tess, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625f);
	}
	

}

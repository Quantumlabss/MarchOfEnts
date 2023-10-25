package com.quantum.marchofents.proxy;



import com.quantum.marchofents.client.util.PikeRender;
import com.quantum.marchofents.init.Items;
import com.quantum.marchofents.items.ItemLebenninPike;


import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class CombinedClientProxy extends CommonProxy {
	
	private final Minecraft minecraft = Minecraft.getMinecraft();
	
	@Override
	public void preInit() {
		super.preInit();
		
		
		
	}
	
	
	




	@Override
	public EntityPlayer getClientPlayer() {
		return minecraft.thePlayer;
	}

}

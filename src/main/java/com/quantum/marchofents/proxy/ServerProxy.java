package com.quantum.marchofents.proxy;

import com.quantum.marchofents.blocks.MOECraftingTableFangorn;
import com.quantum.marchofents.database.MOEGuiId;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ServerProxy  {
	
	
	//@Override
	//public Object getClientGuiElement(int ID, EntityPlayer entityplayer, World world, int i, int j, int k) {
	//	MOEGuiId gui = MOEGuiId.values()[ID];
	//	switch (gui) {
		//	case FANGORN:
			//	return new MOECraftingTableFangorn.Gui(entityplayer.inventory, world, i, j, k);

		//	default:
		//		return null;
	//	}
//	}
	
//	@Override
//	public Object getServerGuiElement(int ID, EntityPlayer entityplayer, World world, int i, int j, int k) {
	//	MOEGuiId gui = MOEGuiId.values()[ID];
	//	switch (gui) {
		//	case FANGORN:
			//	return new MOECraftingTableFangorn.Container(entityplayer.inventory, world, i, j, k);
			//default:
				//return null;
		//}
	//}
	
	public void onInit(FMLInitializationEvent event) {
		
	}
	
	public void preInit(FMLPreInitializationEvent event) {
		
	}



}

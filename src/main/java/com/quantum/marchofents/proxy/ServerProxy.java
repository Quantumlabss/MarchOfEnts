package com.quantum.marchofents.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy  {

	//public EntityPlayer getPlayerEntity(MessageContext ctx) {
	//	return ctx.getServerHandler().playerEntity;
	//}


	
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

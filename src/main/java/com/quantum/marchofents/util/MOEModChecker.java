package com.quantum.marchofents.util;

public class MOEModChecker {
	
	public static int hasNEI = -1;
	public static int hasGuiContainer = -1;

	public static boolean hasGuiContainer() {
		if (hasGuiContainer == -1) {
			try {
				Class.forName("net.minecraft.client.gui.inventory.GuiContainer");
				hasGuiContainer = 1;
			} catch (ClassNotFoundException e) {
				hasGuiContainer = 0;
			}
		}
		return hasGuiContainer == 1;
	}
	
	
	
	public static boolean hasNEI() {
		if (hasNEI == -1) {
			try {
				Class.forName("codechicken.nei.api.API");
				
			}catch (ClassNotFoundException e) {
				hasNEI = 0;
			}
		}
		
		return hasNEI == 1;
	}

}

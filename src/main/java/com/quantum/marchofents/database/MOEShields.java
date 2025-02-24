package com.quantum.marchofents.database;

import lotr.common.LOTRShields;
import lotr.common.fac.LOTRFaction;
import net.minecraft.util.ResourceLocation;

import java.util.Locale;

import com.quantum.marchofents.util.MOECommander;


public class MOEShields {
	
	public static LOTRShields ALIGNMENT_FANGORN;
	
	public static LOTRShields addAlignmentShield(String enumName, LOTRFaction faction) {
		
		LOTRShields shield = MOECommander.addAlignmentShield(enumName, faction);
		MOECommander.setShieldTexture(shield, new ResourceLocation("marchofents", "shield/" + shield.name().toLowerCase(Locale.ROOT) + ".png"));
		
		return shield;
		
		
		
	}
	
	public static void onInit() {
		ALIGNMENT_FANGORN = addAlignmentShield("ALIGNMENT_FANGORN", LOTRFaction.FANGORN);
	}

}

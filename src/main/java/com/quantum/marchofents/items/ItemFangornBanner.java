package com.quantum.marchofents.items;

import com.quantum.marchofents.client.util.MOECommander;

import lotr.common.fac.LOTRFaction;
import lotr.common.item.LOTRItemBanner;

public class ItemFangornBanner {
	
	public static LOTRItemBanner.BannerType FANGORN;
	
	
	public static void preInit() {
		
		FANGORN = MOECommander.addBanner("fangorn", LOTRFaction.FANGORN);
		
		
		
		
		
	}

}

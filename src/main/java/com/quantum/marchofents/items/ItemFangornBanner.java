package com.quantum.marchofents.items;

import lotr.common.fac.LOTRFaction;
import lotr.common.item.LOTRItemBanner;
import com.quantum.marchofents.util.MOECommander;

public class ItemFangornBanner {
	public static LOTRItemBanner.BannerType FANGORN;
	
	
	public static void preInit() {
		
		FANGORN = MOECommander.addBanner("fangorn", LOTRFaction.FANGORN);
		
		
		
		
		
	}

}

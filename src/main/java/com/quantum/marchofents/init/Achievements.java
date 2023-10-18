package com.quantum.marchofents.init;

import com.quantum.marchofents.achievements.LOTRAchievementNauglamir;

import lotr.common.LOTRAchievement;
import lotr.common.LOTRAchievement.Category;
import net.minecraft.stats.Achievement;

public class Achievements {
	public static LOTRAchievement achievementNauglamir;
	
	public static void Init() {
		achievementNauglamir = new LOTRAchievementNauglamir(Category.GENERAL, 0, Items.nauglamir, "Nauglamir");
	}

}

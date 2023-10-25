package com.quantum.marchofents.init;




import lotr.common.LOTRAchievement;
import lotr.common.LOTRAchievement.Category;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;

import net.minecraftforge.common.AchievementPage;

public class Achievements {
	public static LOTRAchievement achievementNauglamir;
	public static EntityPlayer entity;
	
	public static void Init() {
		
		
		//Achievements.achievementNauglamir.broadcastEarning((EntityPlayer) entity);
		achievementNauglamir = new LOTRAchievement(Category.GENERAL, 0, Items.nauglamir, "achievement.nauglamir").createTitle();
		
		
		
		//AchievementPage.registerAchievementPage(new AchievementPage("March Of The Ents Achievements", new Achievement[] {achievementNauglamir}));
	}

}

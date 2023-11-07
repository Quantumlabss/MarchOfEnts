package com.quantum.marchofents.database;

import lotr.common.entity.npc.LOTREntityBlackUruk;
import lotr.common.entity.npc.LOTREntityUrukHai;
import lotr.common.entity.npc.LOTREntityUrukWarg;
import lotr.common.fac.LOTRFaction;
import lotr.common.quest.LOTRMiniQuestBounty;
import lotr.common.quest.LOTRMiniQuestFactory;
import lotr.common.quest.LOTRMiniQuestKillEntity;
import lotr.common.quest.LOTRMiniQuestKillFaction;

import com.quantum.marchofents.init.Achievements;
import com.quantum.marchofents.util.MOECommander;

public class MOEMiniQuestFactory {
	
	public static LOTRMiniQuestFactory FANGORN;
	
	
	public static void addMiniQuestFactories() {
		FANGORN = MOECommander.addMiniQuestFactory("FANGORN", "fangorn");
	}
	
	
	public static void onInit() {
		addMiniQuestFactories();
		setupMiniQuestFactories();
	}
	
	public static void setupMiniQuestFactories() {
		MOECommander.setMiniQuestFactoryAchievement(FANGORN, Achievements.doMiniQuestFangorn);
		
		MOECommander.addMiniQuest(FANGORN, new LOTRMiniQuestKillFaction.QFKillFaction("killIsengard").setKillFaction(LOTRFaction.ISENGARD, 20, 40));
		//MOECommander.addMiniQuest(FANGORN, new LOTRMiniQuestKillEntity.QFKillEntity("killUruk").setKillEntity(LOTREntityUrukHai.class, 10, 30));
		//MOECommander.addMiniQuest(FANGORN, new LOTRMiniQuestKillEntity.QFKillEntity("killWarg").setKillEntity(LOTREntityUrukWarg.class, 10, 30));
		//MOECommander.addMiniQuest(FANGORN, new LOTRMiniQuestBounty.QFBounty<>("bounty"));
	}

}

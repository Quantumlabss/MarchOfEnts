package com.quantum.marchofents.init;




import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import lotr.common.LOTRAchievement;
import lotr.common.LOTRAchievement.Category;
import lotr.common.LOTRLevelData;
import lotr.common.LOTRMod;
import lotr.common.fac.LOTRFaction;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import lotr.common.item.LOTRMaterial;
import com.quantum.marchofents.database.MOEMaterial;
import com.quantum.marchofents.util.MOECommander;

import net.minecraftforge.common.AchievementPage;

public class Achievements {
	
	public static Map<ItemArmor.ArmorMaterial, LOTRAchievement> armorAchievements;
	public static LOTRAchievement getNauglamir;
	public static LOTRAchievement wearFullLebennin;
	public static LOTRAchievement wearFullElvenElite;
	public static LOTRAchievement wearFullFingolfin;
	public static LOTRAchievement wearElvenCirclet;
	public static LOTRAchievement getMithrilSmithingHammer;
	public static LOTRAchievement wearDragonHelm;
	public static LOTRAchievement doMiniQuestFangorn;
	public static LOTRAchievement wearFullFangorn;
	public static LOTRAchievement wearFullEntish;
	public static LOTRAchievement getEntishBranch;
	public static LOTRAchievement getTreebeardHand;
	//public static EntityPlayer entity;
	
	

	
	public static void Init() {
		
		getNauglamir = new LOTRAchievement(Category.LINDON, 100, Items.nauglamir, "getNauglamir").createTitle();
		getMithrilSmithingHammer = new LOTRAchievement(Category.EREGION, 200, Items.mithrilSmithingHammer, "getMithrilSmithingHammer").createTitle();		
		wearFullLebennin = createArmorAchievement(Category.GONDOR, 50, Items.lebenninChestplate, "wearFullLebennin").createTitle();
		wearFullElvenElite = createArmorAchievement(Category.LOTHLORIEN, 400, Items.elvenEliteChestplate, "wearFullElvenElite").createTitle();
		wearFullFingolfin = createArmorAchievement(Category.LINDON, 500, Items.fingolfinChestplate, "wearFullFingolfin").createTitle();
		wearElvenCirclet = createArmorAchievement(Category.LOTHLORIEN, 600, Items.elvenCirclet, "wearElvenCirclet").createTitle();
		wearDragonHelm = createArmorAchievement(Category.LINDON, 700, Items.dragonHelm, "wearDragonHelm").createTitle();
		doMiniQuestFangorn = new LOTRAchievement(Category.FANGORN, 20, LOTRMod.redBook, "doMiniQuestFangorn").setRequiresAlly(LOTRFaction.FANGORN);
		wearFullEntish = createArmorAchievement(Category.FANGORN, 21, Items.entishChestplate, "wearFullEntish").createTitle();
		wearFullFangorn = createArmorAchievement(Category.FANGORN, 22, Items.fangornChestplate, "wearFullFangorn").createTitle();
		getEntishBranch = new LOTRAchievement(Category.FANGORN, 23, Items.entishBranch, "getEntishBranch").createTitle();
		getTreebeardHand = new LOTRAchievement(Category.FANGORN, 24, Items.handOfTreebeard, "getTreebeardHand").createTitle();
	}
	
    private static LOTRAchievement createArmorAchievement(final LOTRAchievement.Category category, final int id, final Item item, final String name) {
        if (!(item instanceof ItemArmor)) {
            throw new IllegalArgumentException("Invalid armor achievement item, name: " + name + " for LOTR achievement category " + category);
        }
        final LOTRAchievement achievement = new LOTRAchievement(category, id, item, name);
        Achievements.armorAchievements.put(((ItemArmor)item).getArmorMaterial(), achievement);
        return achievement;
    }

	
	
    public static void runAchievementCheck(final EntityPlayer player) {
        final ItemArmor.ArmorMaterial material = MOEMaterial.getFullArmorMaterial((EntityLivingBase)player);
        if (Achievements.armorAchievements.containsKey(material)) {
            LOTRLevelData.getData(player).addAchievement((LOTRAchievement)Achievements.armorAchievements.get(material));
        }
    }
    
    static {
        Achievements.armorAchievements = new HashMap<ItemArmor.ArmorMaterial, LOTRAchievement>();
    }
    


	
	
	

}

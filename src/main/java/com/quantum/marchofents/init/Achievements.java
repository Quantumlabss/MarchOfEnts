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
	public static LOTRAchievement getNargothrondBattleaxe;
	public static LOTRAchievement getNumenoreanSword;
	public static LOTRAchievement wearLebenninPlateSet;
	public static LOTRAchievement wearLossarnachPlateSet;
	public static LOTRAchievement craftArnorLongsword;
	public static LOTRAchievement getGondolinBattleaxe;
	public static LOTRAchievement wearSauronSet;
	public static LOTRAchievement getFeanorianSword;
	public static LOTRAchievement getDoriathSword;
	public static LOTRAchievement wearGondorCrown;

	//public static EntityPlayer entity;
	
	

	
	public static void Init() {
		
		getNauglamir = new LOTRAchievement(Category.LINDON, 100, MOEItems.nauglamir, "getNauglamir").createTitle();
		getMithrilSmithingHammer = new LOTRAchievement(Category.EREGION, 200, MOEItems.mithrilSmithingHammer, "getMithrilSmithingHammer").createTitle();		
		wearFullLebennin = createArmorAchievement(Category.GONDOR, 50, MOEItems.lebenninChestplate, "wearFullLebennin").createTitle();
		wearFullElvenElite = createArmorAchievement(Category.LOTHLORIEN, 400, MOEItems.elvenEliteChestplate, "wearFullElvenElite").createTitle();
		wearFullFingolfin = createArmorAchievement(Category.LINDON, 500, MOEItems.fingolfinChestplate, "wearFullFingolfin").createTitle();
		wearElvenCirclet = createArmorAchievement(Category.LOTHLORIEN, 600, MOEItems.elvenCirclet, "wearElvenCirclet").createTitle();
		wearDragonHelm = createArmorAchievement(Category.GONDOR, 700, MOEItems.dragonHelm, "wearDragonHelm").createTitle();
		doMiniQuestFangorn = new LOTRAchievement(Category.FANGORN, 20, LOTRMod.redBook, "doMiniQuestFangorn").setRequiresAlly(LOTRFaction.FANGORN);
		//wearFullEntish = createArmorAchievement(Category.FANGORN, 21, MOEItems.entishChestplate, "wearFullEntish").createTitle();
		//wearFullFangorn = createArmorAchievement(Category.FANGORN, 22, MOEItems.fangornChestplate, "wearFullFangorn").createTitle();
	//	getEntishBranch = new LOTRAchievement(Category.FANGORN, 23, MOEItems.entishBranch, "getEntishBranch").createTitle();
	//	getTreebeardHand = new LOTRAchievement(Category.FANGORN, 24, MOEItems.handOfTreebeard, "getTreebeardHand").createTitle();
		getNargothrondBattleaxe = new LOTRAchievement(Category.LOTHLORIEN, 601, MOEItems.nargothrondBattleAxe, "getNargothrondBattleaxe").createTitle();
		getNumenoreanSword = new LOTRAchievement(Category.GONDOR, 51, MOEItems.numenoreanSword, "getNumenoreanSword").createTitle();
		
		wearLossarnachPlateSet = createArmorAchievement(Category.GONDOR, 52, MOEItems.lossarnachChestplate, "wearLossarnachPlateSet").createTitle();
		craftArnorLongsword = new LOTRAchievement(Category.ERIADOR, 100, MOEItems.longswordArnor, "craftArnorLongsword").createTitle();
		getGondolinBattleaxe = new LOTRAchievement(Category.LINDON, 800, MOEItems.gondolinBattleAxe, "getGondolinBattleaxe").createTitle();
		//sauronset
		getFeanorianSword = new LOTRAchievement(Category.LINDON, 850, MOEItems.feanorianSword, "getFeanorianSword").createTitle();
		getDoriathSword = new LOTRAchievement(Category.LOTHLORIEN, 650, MOEItems.doriathSword, "getDoriathSword").createTitle();
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

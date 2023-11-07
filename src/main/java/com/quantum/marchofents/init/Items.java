package com.quantum.marchofents.init;

import com.google.common.base.CaseFormat;
import com.quantum.marchofents.MarchOfEnts;
import com.quantum.marchofents.database.MOEMaterial;
import com.quantum.marchofents.items.ItemElvenCirclet;
import com.quantum.marchofents.items.ItemElvenEliteArmor;
import com.quantum.marchofents.items.ItemFingolfinArmor;
import com.quantum.marchofents.items.ItemLebenninArmor;
import com.quantum.marchofents.items.ItemLebenninHelmet;
import com.quantum.marchofents.items.ItemNauglamir;
import com.quantum.marchofents.items.ItemDragonHelm;
import com.quantum.marchofents.items.MOEItemArmor;

import lotr.common.item.LOTRItemBattleaxe;
import lotr.common.item.LOTRItemHammer;
import lotr.common.item.LOTRItemPike;
import lotr.common.item.LOTRItemSword;
import lotr.common.item.LOTRMaterial;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Items {
	
	
	//items
	public static Item longswordArnor;
	public static Item nargothrondLongsword;
	public static Item nargothrondBattleAxe;
	public static Item feanorianSword;
	public static Item gondolinBattleAxe;
	public static Item gondolinWarHammer;
	public static Item gondorWarHammer;
	public static Item mithrilSmithingHammer;
	public static Item doriathSword;
	public static Item nauglamir;
	public static Item numenoreanScimitar;
	public static Item numenoreanSword;
	public static Item pikeLebennin;
	public static Item lebenninSword;
	public static Item entishBranch;
	public static Item handOfTreebeard;
	public static Item lebenninHelmet;
	public static Item lebenninChestplate;
	public static Item lebenninLeggings;
	public static Item lebenninBoots;
	public static Item elvenEliteHelm;
	public static Item elvenEliteChestplate;
	public static Item elvenEliteLeggings;
	public static Item elvenEliteBoots;
	public static Item fingolfinHelm;
	public static Item fingolfinChestplate;
	public static Item fingolfinLeggings;
	public static Item fingolfinBoots;
	public static Item elvenCirclet;
	public static Item dragonHelm;
	public static Item fangornHelm;
	public static Item fangornChestplate;
	public static Item fangornLeggings;
	public static Item fangornBoots;
	public static Item entishHelmet;
	public static Item entishChestplate;
	public static Item entishLeggings;
	public static Item entishBoots;
	
	//tool materials
	public static void Init() {
		Items.preInit();
		Items.registerItems();
		
		
	}
	
	public static void preInit()
	{

		//item init
		longswordArnor = new LOTRItemSword(LOTRMaterial.ARNOR);
		numenoreanScimitar = new LOTRItemSword(LOTRMaterial.BLACK_NUMENOREAN);
		numenoreanSword = new LOTRItemSword(LOTRMaterial.BLACK_NUMENOREAN);
		pikeLebennin = new LOTRItemPike(LOTRMaterial.GONDOR);
		lebenninSword = new LOTRItemSword(LOTRMaterial.GONDOR);
		nargothrondBattleAxe = new LOTRItemBattleaxe(LOTRMaterial.HIGH_ELVEN);
		nargothrondLongsword = new LOTRItemSword(LOTRMaterial.HIGH_ELVEN).setIsElvenBlade();
		mithrilSmithingHammer = new LOTRItemHammer(LOTRMaterial.MITHRIL);
		doriathSword = new LOTRItemSword(LOTRMaterial.HIGH_ELVEN).setIsElvenBlade();
		feanorianSword = new LOTRItemSword(LOTRMaterial.HIGH_ELVEN).setIsElvenBlade();
		gondolinBattleAxe = new LOTRItemBattleaxe(LOTRMaterial.GONDOLIN);
		gondolinWarHammer = new LOTRItemHammer(LOTRMaterial.GONDOLIN);
		entishBranch = new LOTRItemHammer(MOEMaterial.ENTISH);
		handOfTreebeard = new LOTRItemHammer(LOTRMaterial.MALLORN_MACE);
		nauglamir = new ItemNauglamir().setUnlocalizedName("itemNauglamir").setTextureName("marchofents:nauglamir").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		
		//armor item
		lebenninHelmet = new ItemLebenninHelmet();
		lebenninChestplate = new MOEItemArmor(MOEMaterial.LEBENNIN, 1);
		lebenninLeggings = new MOEItemArmor(MOEMaterial.LEBENNIN, 2);
		lebenninBoots = new MOEItemArmor(MOEMaterial.LEBENNIN, 3);
		elvenEliteHelm = new MOEItemArmor(MOEMaterial.HIGH_ELVEN_ELITE, 0);
		elvenEliteChestplate = new MOEItemArmor(MOEMaterial.HIGH_ELVEN_ELITE, 1);
		elvenEliteLeggings = new MOEItemArmor(MOEMaterial.HIGH_ELVEN_ELITE, 2);
		elvenEliteBoots = new MOEItemArmor(MOEMaterial.HIGH_ELVEN_ELITE, 3);
		fingolfinHelm = new MOEItemArmor(MOEMaterial.FINGOLFIN, 0);
		fingolfinChestplate = new MOEItemArmor(MOEMaterial.FINGOLFIN, 1);
		fingolfinLeggings = new MOEItemArmor(MOEMaterial.FINGOLFIN, 2);
		fingolfinBoots = new MOEItemArmor(MOEMaterial.FINGOLFIN, 3);
		elvenCirclet = new MOEItemArmor(MOEMaterial.ELVEN_CIRCLET, 0);
		fangornHelm = new MOEItemArmor(MOEMaterial.FANGORN, 0);
		fangornChestplate = new MOEItemArmor(MOEMaterial.FANGORN, 1);
		fangornLeggings = new MOEItemArmor(MOEMaterial.FANGORN, 2);
		fangornBoots = new MOEItemArmor(MOEMaterial.FANGORN, 3);
		entishHelmet = new MOEItemArmor(MOEMaterial.ENTISH, 0);
		entishChestplate = new MOEItemArmor(MOEMaterial.ENTISH, 1);
		entishLeggings = new MOEItemArmor(MOEMaterial.ENTISH, 2);
		entishBoots = new MOEItemArmor(MOEMaterial.ENTISH, 3);
		dragonHelm = new ItemDragonHelm();
		

		
		
		//Item Register
		GameRegistry.registerItem(nauglamir, nauglamir.getUnlocalizedName().substring(5));
		
		
		
	}
	private static void registerItems() {
		Items.nameAndRegisterItem(pikeLebennin, "pikeLebennin");
		Items.nameAndRegisterItem(longswordArnor, "longswordArnor");
		Items.nameAndRegisterItem(lebenninSword, "lebenninSword");
		Items.nameAndRegisterItem(numenoreanScimitar, "numenoreanScimitar");
		Items.nameAndRegisterItem(numenoreanSword, "numenoreanSword");
		Items.nameAndRegisterItem(nargothrondBattleAxe, "nargothrondBattleaxe");
		Items.nameAndRegisterItem(nargothrondLongsword, "nargothrondLongsword");
		Items.nameAndRegisterItem(mithrilSmithingHammer, "mithrilSmithingHammer");
		Items.nameAndRegisterItem(doriathSword, "doriathSword");
		Items.nameAndRegisterItem(feanorianSword, "feanorianSword");
		Items.nameAndRegisterItem(gondolinBattleAxe, "gondolinBattleaxe");
		Items.nameAndRegisterItem(gondolinWarHammer, "gondolinWarhammer");
		Items.nameAndRegisterItem(lebenninHelmet, "lebenninHelmet");
		Items.nameAndRegisterItem(lebenninChestplate, "lebenninChestplate");
		Items.nameAndRegisterItem(lebenninLeggings, "lebenninLeggings");
		Items.nameAndRegisterItem(lebenninBoots, "lebenninBoots");
		Items.nameAndRegisterItem(elvenEliteHelm, "elvenEliteHelm");
		Items.nameAndRegisterItem(elvenEliteChestplate, "elvenEliteChestplate");
		Items.nameAndRegisterItem(elvenEliteLeggings, "elvenEliteLeggings");
		Items.nameAndRegisterItem(elvenEliteBoots, "elvenEliteBoots");
		Items.nameAndRegisterItem(fingolfinHelm, "fingolfinHelm");
		Items.nameAndRegisterItem(fingolfinChestplate, "fingolfinChestplate");
		Items.nameAndRegisterItem(fingolfinLeggings, "fingolfinLeggings");
		Items.nameAndRegisterItem(fingolfinBoots, "fingolfinBoots");
		Items.nameAndRegisterItem(elvenCirclet, "elvenCirclet");
		Items.nameAndRegisterItem(dragonHelm, "dragonHelm");
		Items.nameAndRegisterItem(fangornHelm, "fangornHelm");
		Items.nameAndRegisterItem(fangornChestplate, "fangornChestplate");
		Items.nameAndRegisterItem(fangornLeggings, "fangornLeggings");
		Items.nameAndRegisterItem(fangornBoots, "fangornBoots");
		Items.nameAndRegisterItem(entishHelmet, "entishHelmet");
		Items.nameAndRegisterItem(entishChestplate, "entishChestplate");
		Items.nameAndRegisterItem(entishLeggings, "entishLeggings");
		Items.nameAndRegisterItem(entishBoots, "entishBoots");
		Items.nameAndRegisterItem(entishBranch, "entishBranch");
		Items.nameAndRegisterItem(handOfTreebeard, "handOfTreebeard");

		
	}
	
	private static void nameAndRegisterItem(Item item, String name) {
		String itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		item.setUnlocalizedName(itemName);
		
		item.setTextureName("marchofents:" + itemName);
		item.setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		GameRegistry.registerItem((Item)item, (String)itemName);
	}
	
	private static void nameAndRegisterItem(Item item, String name, String textureName) {
		String itemName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
		item.setUnlocalizedName(itemName);
		
		item.setTextureName(textureName);
		item.setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		GameRegistry.registerItem((Item)item, (String)itemName);
		
	}

	public static void registerItemLOTR(Item item, String name) {
		item.setTextureName("lotr:" + name);
		item.setUnlocalizedName("lotr:" + name);
		GameRegistry.registerItem(item, name);
	}
	


}

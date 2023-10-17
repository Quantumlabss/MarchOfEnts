package com.quantum.marchofents.init;

import com.quantum.marchofents.MarchOfEnts;
import com.quantum.marchofents.items.ItemArnorLongsword;
import com.quantum.marchofents.items.ItemDoriathSword;
import com.quantum.marchofents.items.ItemElvenCirclet;
import com.quantum.marchofents.items.ItemElvenEliteArmor;
import com.quantum.marchofents.items.ItemFeanorianSword;
import com.quantum.marchofents.items.ItemFingolfinArmor;
import com.quantum.marchofents.items.ItemGondolinBattleAxe;
import com.quantum.marchofents.items.ItemGondolinWarHammer;
import com.quantum.marchofents.items.ItemGondorWarHammer;
import com.quantum.marchofents.items.ItemLebenninArmor;
import com.quantum.marchofents.items.ItemLebenninPike;
import com.quantum.marchofents.items.ItemLebenninSword;
import com.quantum.marchofents.items.ItemMithrilSmithingHammer;
import com.quantum.marchofents.items.ItemNargothrondBattleAxe;
import com.quantum.marchofents.items.ItemNargothrondLongsword;
import com.quantum.marchofents.items.ItemNauglamir;
import com.quantum.marchofents.items.ItemNumenorScimitar;
import com.quantum.marchofents.items.ItemNumenoreanSword;

import lotr.common.item.LOTRItemSword;
import lotr.common.item.LOTRMaterial;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Items {
	
	
	//items
	public static Item arnorianLongsword;
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
	public static Item lebenninPike;
	public static Item lebenninSword;
	public static Item lebenninHelm;
	public static Item lebenninChestPlate;
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
	//tool materials
	
	
	public static void init()
	{

		//item init
		arnorianLongsword = new ItemArnorLongsword(LOTRMaterial.ARNOR).setUnlocalizedName("ItemArnorLongsword").setTextureName("marchofents:dunedain_sword").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		nargothrondLongsword = new ItemNargothrondLongsword(LOTRMaterial.HIGH_ELVEN).setIsElvenBlade().setUnlocalizedName("ItemNargothrondLongsword").setTextureName("marchofents:nargothrond_sword").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		feanorianSword = new ItemFeanorianSword(LOTRMaterial.HIGH_ELVEN).setIsElvenBlade().setUnlocalizedName("ItemFeanorianSword").setTextureName("marchofents:feanorian_sword").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		gondolinBattleAxe = new ItemGondolinBattleAxe(LOTRMaterial.GONDOLIN).setUnlocalizedName("ItemGondolinBattleAxe").setTextureName("marchofents:Gondolin_battleaxe").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		gondolinWarHammer = new ItemGondolinWarHammer(LOTRMaterial.GONDOLIN).setUnlocalizedName("ItemGondolinWarHammer").setTextureName("marchofents:gondolin_hammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		gondorWarHammer = new ItemGondorWarHammer(LOTRMaterial.GONDOR).setUnlocalizedName("ItemGondorWarHammer").setTextureName("marchofents:Gondor_warhammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		mithrilSmithingHammer = new ItemMithrilSmithingHammer(LOTRMaterial.MITHRIL).setUnlocalizedName("ItemMithrilSmithingHammer").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		nargothrondBattleAxe = new ItemNargothrondBattleAxe(LOTRMaterial.HIGH_ELVEN).setUnlocalizedName("ItemNargothrondBattleAxe").setTextureName("marchofents:nargothrond_battleaxe").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		doriathSword = new ItemDoriathSword(LOTRMaterial.HIGH_ELVEN).setIsElvenBlade().setUnlocalizedName("ItemDoriathSword").setTextureName("marchofents:doriath_sword").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		nauglamir = new ItemNauglamir().setUnlocalizedName("ItemNauglamir").setTextureName("marchofents:Nauglamir").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		numenoreanScimitar = new ItemNumenorScimitar(LOTRMaterial.BLACK_NUMENOREAN).setUnlocalizedName("ItemNumenorScimitar").setTextureName("marchofents:numenorean_scimitar").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		numenoreanSword = new ItemNumenoreanSword(LOTRMaterial.BLACK_NUMENOREAN).setUnlocalizedName("ItemNumenoreanSword").setTextureName("marchofents:numenorean_sword").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		lebenninPike = new ItemLebenninPike(LOTRMaterial.PELARGIR).setUnlocalizedName("ItemLebenninPike").setTextureName("marchofents/Large-2:pike_lebennin").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		lebenninSword = new ItemLebenninSword(LOTRMaterial.PELARGIR).setUnlocalizedName("ItemLebenninSword").setTextureName("marchofents:sword_lebennin").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		lebenninHelm = new ItemLebenninArmor(LOTRMaterial.PELARGIR, 0, 0).setUnlocalizedName("ItemLebenninHelm").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		lebenninChestPlate = new ItemLebenninArmor(LOTRMaterial.PELARGIR, 1, 0).setUnlocalizedName("ItemLebenninChestPlate").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		lebenninLeggings = new ItemLebenninArmor(LOTRMaterial.PELARGIR, 2, 0).setUnlocalizedName("ItemLebenninLeggings").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		lebenninBoots = new ItemLebenninArmor(LOTRMaterial.PELARGIR, 3, 0).setUnlocalizedName("ItemLebenninBoots").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		elvenEliteHelm = new ItemElvenEliteArmor(LOTRMaterial.HIGH_ELVEN, 0).setUnlocalizedName("ItemElvenEliteHelm").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		elvenEliteChestplate = new ItemElvenEliteArmor(LOTRMaterial.HIGH_ELVEN, 1).setUnlocalizedName("ItemElvenEliteChestplate").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		elvenEliteLeggings = new ItemElvenEliteArmor(LOTRMaterial.HIGH_ELVEN, 2).setUnlocalizedName("ItemElvenEliteLeggings").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		elvenEliteBoots = new ItemElvenEliteArmor(LOTRMaterial.HIGH_ELVEN, 3).setUnlocalizedName("ItemElvenEliteBoots").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		fingolfinHelm = new ItemFingolfinArmor(LOTRMaterial.GONDOLIN, 0).setUnlocalizedName("ItemFingolfinHelm").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		fingolfinChestplate = new ItemFingolfinArmor(LOTRMaterial.GONDOLIN, 1).setUnlocalizedName("ItemFingolfinChestplate").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		fingolfinLeggings = new ItemFingolfinArmor(LOTRMaterial.GONDOLIN, 2).setUnlocalizedName("ItemFingolfinLeggings").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		fingolfinBoots = new ItemFingolfinArmor(LOTRMaterial.GONDOLIN, 3).setUnlocalizedName("ItemFingolfinBoots").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		elvenCirclet = new ItemElvenCirclet(LOTRMaterial.GALADHRIM, 0).setUnlocalizedName("ItemElvenCirclet").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		
		
		
		//Item Register
		GameRegistry.registerItem(arnorianLongsword, arnorianLongsword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(nargothrondLongsword, nargothrondLongsword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(nargothrondBattleAxe, nargothrondBattleAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(feanorianSword, feanorianSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(gondolinBattleAxe, gondolinBattleAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(gondolinWarHammer, gondolinWarHammer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(gondorWarHammer, gondorWarHammer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(mithrilSmithingHammer, mithrilSmithingHammer.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(doriathSword, doriathSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(nauglamir, nauglamir.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(numenoreanScimitar, numenoreanScimitar.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(numenoreanSword, numenoreanSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lebenninPike, lebenninPike.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lebenninHelm, lebenninHelm.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lebenninChestPlate, lebenninChestPlate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lebenninLeggings, lebenninLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lebenninBoots, lebenninBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(elvenEliteHelm, elvenEliteHelm.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(elvenEliteChestplate, elvenEliteChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(elvenEliteLeggings, elvenEliteLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(elvenEliteBoots, elvenEliteBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fingolfinHelm, fingolfinHelm.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fingolfinChestplate, fingolfinChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fingolfinLeggings, fingolfinLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fingolfinBoots, fingolfinBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(elvenCirclet, elvenCirclet.getUnlocalizedName().substring(5));
	}

}

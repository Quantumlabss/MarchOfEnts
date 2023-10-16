package com.quantum.marchofents.init;

import com.quantum.marchofents.MarchOfEnts;
import com.quantum.marchofents.items.ItemArnorLongsword;
import com.quantum.marchofents.items.ItemDoriathSword;
import com.quantum.marchofents.items.ItemFeanorianSword;
import com.quantum.marchofents.items.ItemGondolinBattleAxe;
import com.quantum.marchofents.items.ItemGondolinWarHammer;
import com.quantum.marchofents.items.ItemGondorWarHammer;
import com.quantum.marchofents.items.ItemMithrilSmithingHammer;
import com.quantum.marchofents.items.ItemNargothrondBattleAxe;
import com.quantum.marchofents.items.ItemNargothrondLongsword;

import lotr.common.item.LOTRItemSword;
import lotr.common.item.LOTRMaterial;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
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
	
	//tool materials
	public static final Item.ToolMaterial longswordMaterial = EnumHelper.addToolMaterial("longswordToolMaterial", 4, 2000, 20.0F, 5.0F, 30);
	public static final Item.ToolMaterial placeHolderMaterial = EnumHelper.addToolMaterial("placeHolderMaterial", 4, 2000, 20.0F, 4.0F, 30);

	
	public static void init()
	{

		//item init
		arnorianLongsword = new ItemArnorLongsword(LOTRMaterial.ARNOR).setUnlocalizedName("ItemArnorLongsword").setTextureName("marchofents:dunedain_sword").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		nargothrondLongsword = new ItemNargothrondLongsword(LOTRMaterial.HIGH_ELVEN).setIsElvenBlade().setUnlocalizedName("ItemNargothrondLongsword").setTextureName("marchofents:nargothrond_sword").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		feanorianSword = new ItemFeanorianSword(LOTRMaterial.HIGH_ELVEN).setIsElvenBlade().setUnlocalizedName("ItemFeanorianSword").setTextureName("marchofents:feanorian_sword").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		gondolinBattleAxe = new ItemGondolinBattleAxe(LOTRMaterial.GONDOLIN).setUnlocalizedName("ItemGondolinBattleAxe").setTextureName("marchofents:Gondolin_battleaxe").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		gondolinWarHammer = new ItemGondolinWarHammer(LOTRMaterial.GONDOLIN).setUnlocalizedName("ItemGondolinWarHammer").setTextureName("marchofents:gondolin_hammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		gondorWarHammer = new ItemGondorWarHammer(LOTRMaterial.GONDOR).setUnlocalizedName("ItemGondowWarHammer").setTextureName("marchofents:Gondor_warhammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		mithrilSmithingHammer = new ItemMithrilSmithingHammer(LOTRMaterial.MITHRIL).setUnlocalizedName("ItemMithrilSmithingHammer").setTextureName("marchofents:MithrilSmithingHammer").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		nargothrondBattleAxe = new ItemNargothrondBattleAxe(LOTRMaterial.HIGH_ELVEN).setIsElvenBlade().setUnlocalizedName("ItemNargothrondBattleAxe").setTextureName("marchofents:nargothrond_battleaxe").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		doriathSword = new ItemDoriathSword(LOTRMaterial.HIGH_ELVEN).setIsElvenBlade().setUnlocalizedName("ItemDoriathSword").setTextureName("marchofents:doriath_sword").setCreativeTab(MarchOfEnts.tabMarchOfEnts);
		
		
		
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
	}

}

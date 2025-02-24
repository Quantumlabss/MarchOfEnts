package com.quantum.marchofents.util;

import lotr.common.LOTRMod;
import lotr.common.block.LOTRBlockOre;
import lotr.common.world.biome.LOTRBiome;
import lotr.common.world.biome.LOTRBiomeGenMistyMountains;
import lotr.common.world.biome.LOTRMusicRegion;
import lotr.common.world.map.LOTRWaypoint;

public class MOEMoria extends LOTRBiome {
    public MOEMoria(int i, boolean major) {
        super(i, major);
        //decorator.biomeOreFactor(LOTRMod.oreMithril, 10);
        //decorator.addOre(, 100, 10, 100);
    }

    @Override
    public LOTRWaypoint.Region getBiomeWaypoints() {
        return LOTRWaypoint.Region.MISTY_MOUNTAINS;

    }

    @Override
    public LOTRMusicRegion.Sub getBiomeMusic() {
        return null;
    }
}

package com.quantum.marchofents.init;

import com.quantum.marchofents.util.MOEMoria;
import lotr.common.LOTRDimension;
import lotr.common.world.biome.LOTRBiome;

public class MOEBiomes {

    public static LOTRBiome moria;
    //private Biomes() {

   // }

    public static void onInit() {
        for (int i : new int[]{200}) {
            LOTRDimension.MIDDLE_EARTH.biomeList[i] = null;
        }
        moria = new MOEMoria(200, true).setTemperatureRainfall(0.28f, 0.2f).setMinMaxHeight(2.0f, 2.0f).setColor(0xD3D3D4).setBiomeName("Moria");
    }
}



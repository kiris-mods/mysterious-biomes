package dev.tophatcat.mysteriousbiomes;

import net.fabricmc.api.ModInitializer;

public class MysteriousFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        MysteriousCommon.init();
    }
}

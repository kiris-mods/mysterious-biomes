package dev.tophatcat.mysteriousbiomes;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(MysteriousCommon.MOD_ID)
public class MysteriousNeo {

    public MysteriousNeo(IEventBus bus) {
        MysteriousCommon.init();
    }
}

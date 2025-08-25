package space.greymuzzzle.mods.tyrmod;

import net.fabricmc.api.ModInitializer;
import space.greymuzzzle.mods.tyrmod.block.ModBlocks;

public class Tyrmod implements ModInitializer {
    public static final String MOD_ID = "tyrmod";

    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
    }
}

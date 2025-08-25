package space.greymuzzzle.mods.tyrmod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.greymuzzzle.mods.tyrmod.block.ModBlocks;

public class Tyrmod implements ModInitializer {
    public static final String MOD_ID = "tyrmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing TyrMod");
        ModBlocks.registerModBlocks();
        LOGGER.info("TyrMod initialized successfully");
    }
}

package space.greymuzzzle.mods.tyrmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final String MOD_ID = "tyrmod";
    
    public static Block SMOOTH_STONE_STAIRS;
    
    private static Block registerBlock(String name, java.util.function.Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(MOD_ID, name);
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, id);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
        
        Block block = blockFactory.apply(settings.registryKey(blockKey));
        
        BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
        
        Registry.register(Registries.BLOCK, blockKey, block);
        Registry.register(Registries.ITEM, itemKey, blockItem);
        
        return block;
    }
    
    public static void registerModBlocks() {
        SMOOTH_STONE_STAIRS = registerBlock("smooth_stone_stairs",
                settings -> new StairsBlock(Blocks.SMOOTH_STONE.getDefaultState(), settings),
                AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE));
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(SMOOTH_STONE_STAIRS);
        });
    }
}
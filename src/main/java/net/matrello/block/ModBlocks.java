package net.matrello.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.matrello.Seeeeees;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block GREEN_GEM_BLOCK = registerBlock("greengemblock", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block GREEN_GEM_ORE = registerBlock("greengemore", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    private static void addItemToIngredientTab(FabricItemGroupEntries entries){
        entries.add(GREEN_GEM_BLOCK);
        entries.add(GREEN_GEM_ORE);
    }

    private static Block registerBlock(String name, Block block ){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Seeeeees.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block  block){
        return Registry.register(
                Registries.ITEM,
                new Identifier(Seeeeees.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()
                ));
    }

    public static void regiterModBlocks(){
        Seeeeees.LOGGER.info("Registrazione oggetti");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModBlocks::addItemToIngredientTab);
    }
}

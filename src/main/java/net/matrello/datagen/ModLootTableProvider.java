package net.matrello.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.matrello.block.ModBlocks;
import net.matrello.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate()
    {
        addDrop(ModBlocks.GREEN_GEM_BLOCK);

        addDrop(ModBlocks.GREEN_GEM_ORE, copperOreLikeDrops(ModBlocks.GREEN_GEM_ORE, ModItems.GREEN_GEM));
    }

    public LootTable.Builder copperOreLikeDrops(Block silkdrop, Item normal ) {
        return BlockLootTableGenerator.dropsWithSilkTouch(silkdrop, (LootPoolEntry.Builder)this.applyExplosionDecay(silkdrop, ((LeafEntry.Builder) ItemEntry.builder(normal).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)))).apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}

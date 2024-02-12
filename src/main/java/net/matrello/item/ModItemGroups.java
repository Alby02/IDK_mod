package net.matrello.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.matrello.Seeeeees;
import net.matrello.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup GREEN_GEM_GROOP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Seeeeees.MOD_ID, "gem"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.gem"))
                    .icon(() -> new ItemStack(ModItems.GREEN_GEM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.GREEN_GEM);
                        entries.add(ModBlocks.GREEN_GEM_BLOCK);
                        entries.add(ModBlocks.GREEN_GEM_ORE);
                    })
                    .build());

    public static void setUp(){

    }
}

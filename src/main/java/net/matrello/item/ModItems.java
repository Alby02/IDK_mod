package net.matrello.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.matrello.Seeeeees;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item GREEN_GEM = registerItem("greengem", new Item(new FabricItemSettings()));
    private static void addItemToIngredientTab(FabricItemGroupEntries entries){
        entries.add(GREEN_GEM);
    }
    private static Item registerItem(String name, Item  item){
        return Registry.register(Registries.ITEM, new Identifier(Seeeeees.MOD_ID, name), item);
    }

    public static void regiterModItems(){
        Seeeeees.LOGGER.info("Registrazione oggetti");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientTab);
    }
}

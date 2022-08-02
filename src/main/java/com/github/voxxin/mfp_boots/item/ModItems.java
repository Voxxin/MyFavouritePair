package com.github.voxxin.mfp_boots.item;

import com.github.voxxin.mfp_boots.Mfp_boots;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item LEATHER_WOOL = registerItem("wool_leather_boots",
            new ArmorItem(ModArmorMaterials.LEATHER_WOOL, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item LEATHER_COPPER = registerItem("copper_leather_boots",
            new ArmorItem(ModArmorMaterials.LEATHER_COPPER, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item LEATHER_RABBIT_HIDE = registerItem("rabbit_hide_leather_boots",
            new ArmorItem(ModArmorMaterials.LEATHER_RABBIT_HIDE, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Mfp_boots.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Mfp_boots.LOGGER.debug("Registering Mod Items for " + Mfp_boots.MOD_ID);
    }
}

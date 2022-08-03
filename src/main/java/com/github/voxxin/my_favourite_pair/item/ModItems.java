package com.github.voxxin.my_favourite_pair.item;

import com.github.voxxin.my_favourite_pair.MyFavouritePair;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.impl.tag.convention.TagRegistration;
import net.minecraft.data.server.AbstractTagProvider;
import net.minecraft.data.server.ItemTagProvider;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.tag.EntityTypeTags;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item LEATHER_WOOL = registerItem("woolly_leather_boots",
            new ArmorItem(ModArmorMaterials.LEATHER_WOOL, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item LEATHER_COPPER = registerItem("heavy_leather_boots",
            new ArmorItem(ModArmorMaterials.LEATHER_COPPER, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    public static final Item LEATHER_RABBIT_HIDE = registerItem("light_leather_boots",
            new ArmorItem(ModArmorMaterials.LEATHER_RABBIT_HIDE, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ItemGroup.COMBAT)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MyFavouritePair.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MyFavouritePair.LOGGER.debug("Registering Mod Items for " + MyFavouritePair.MOD_ID);
    }
}

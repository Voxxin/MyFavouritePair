package com.github.voxxin.my_favourite_pair.util;

import com.github.voxxin.my_favourite_pair.MyFavouritePair;
import com.mojang.datafixers.types.templates.Tag;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTags {
    public static final TagKey<Item> DAMPENS_VIBRATIONS = TagKey.of(Registry.ITEM_KEY, new Identifier(MyFavouritePair.MOD_ID, "dampens_vibrations"));
}


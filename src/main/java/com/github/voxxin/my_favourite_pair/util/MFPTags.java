package com.github.voxxin.my_favourite_pair.util;

import com.github.voxxin.my_favourite_pair.MyFavouritePair;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MFPTags {
    public static final TagKey<Item> DAMPENS_VIBRATIONS = TagKey.of(Registry.ITEM_KEY, new Identifier(MyFavouritePair.MOD_ID, "dampens_vibrations"));
    public static final TagKey<Item> FREEZE_IMMUNE_WEARABLES = TagKey.of(Registry.ITEM_KEY, new Identifier(MyFavouritePair.MOD_ID, "freeze_immune_wearables"));
}


package com.github.voxxin.my_favourite_pair;

import com.github.voxxin.my_favourite_pair.item.MFPItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFavouritePair implements ModInitializer {
    public static final String MOD_ID = "my_favourite_pair";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        MFPItems.registerModItems();

    }
}

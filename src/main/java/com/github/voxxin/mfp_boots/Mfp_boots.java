package com.github.voxxin.mfp_boots;

import com.github.voxxin.mfp_boots.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mfp_boots implements ModInitializer {
    public static final String MOD_ID = "my_favourite_pair";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        ModItems.registerModItems();

    }
}

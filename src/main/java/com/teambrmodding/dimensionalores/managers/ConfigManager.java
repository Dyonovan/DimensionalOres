package com.teambrmodding.dimensionalores.managers;

import com.teambrmodding.dimensionalores.lib.Reference;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * This file was created for Dimensional Ores
 * <p>
 * Dimensional Ores is licensed under the
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/
 *
 * @author Dyonovan
 * @since 3/24/2016
 */
public class ConfigManager {

    public static Boolean mobsAggravate;
    public static Integer mobsAggroRange;

    public static void preInit(String configFolder) {
        Configuration config = new Configuration(new File(configFolder + File.separator + "NetherOresRedux.cfg"));

        config.load();

        mobsAggravate = config.get(Reference.MOBS_AGGRO, "mobsAggravate", true, "Do mobs aggravate when ore is mined?").getBoolean();
        mobsAggroRange  = config.get(Reference.MOBS_AGGRO, "mobsAggravateRange", 10, "Range mobs aggravate when ore is mined?").getInt();

        config.save();
    }
}

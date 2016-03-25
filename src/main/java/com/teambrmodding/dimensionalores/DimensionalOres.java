package com.teambrmodding.dimensionalores;

import com.teambrmodding.dimensionalores.lib.Reference;
import com.teambrmodding.dimensionalores.managers.ConfigManager;
import com.teambrmodding.dimensionalores.managers.EventManager;
import com.teambrmodding.dimensionalores.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
@SuppressWarnings("unused")
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES,
        updateJSON = Reference.UPDATE_JSON)
public class DimensionalOres {

    @Instance(Reference.MOD_ID)
    public static DimensionalOres instance;

    @SidedProxy(clientSide = "com.teambrmodding.dimensionalores.proxy.ClientProxy",
                serverSide = "com.teambrmodding.dimensionalores.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static CreativeTabs tabDimensionalOres = new CreativeTabs("tabDimensionalOres") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.netherrack);
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ConfigManager.preInit(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + "DimensionalOres");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(EventManager.INSTANCE);
    }
}

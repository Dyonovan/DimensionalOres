package com.teambrmodding.dimensionalores.managers;

import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

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
public class EventManager {
    public static EventManager INSTANCE = new EventManager();

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {

    }

    private void angerPigmen(EntityPlayer player, World world, BlockPos pos) {

        int aggroRange = ConfigManager.mobsAggroRange;

        List<EntityPigZombie> pigList = world.getEntitiesWithinAABB(EntityPigZombie.class,
                new AxisAlignedBB(pos.add(-aggroRange, -aggroRange, -aggroRange),
                        pos.add(aggroRange + 1, aggroRange + 1, aggroRange + 1)));
        for (EntityPigZombie list : pigList) {
            if (list != null)
                list.attackEntityFrom(DamageSource.causePlayerDamage(player), 0);
        }
    }
}

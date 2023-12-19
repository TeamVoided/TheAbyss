package org.teamvoided.theabyss.oxygen

import net.minecraft.entity.LivingEntity
import net.minecraft.world.WorldAccess

object Oxygen {
    fun getEntityDepth(player: LivingEntity, world: WorldAccess): Int {
        var pos = player.blockPos

        var depth = 0
        while (world.isWater(pos)) {
            depth++
            pos = pos.add(0, 1, 0)
        }

        return depth
    }
}
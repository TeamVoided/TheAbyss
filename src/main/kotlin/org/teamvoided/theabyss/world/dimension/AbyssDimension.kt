package org.teamvoided.theabyss.world.dimension

import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.tag.BlockTags
import net.minecraft.util.Identifier
import net.minecraft.util.math.int_provider.UniformIntProvider
import net.minecraft.world.World
import net.minecraft.world.dimension.DimensionOptions
import net.minecraft.world.dimension.DimensionType
import net.minecraft.world.dimension.DimensionType.MonsterSettings
import net.minecraft.world.dimension.DimensionTypes
import net.minecraft.world.gen.BootstrapContext
import org.teamvoided.theabyss.Abyss.id
import java.util.*

@Suppress("MemberVisibilityCanBePrivate", "unused")
object AbyssDimension {
    val ABYSS_ID: Identifier = id("abyss")


    val ABYSS_TYPE: RegistryKey<DimensionType?> = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, id("abyss_type"))
    val ABYSS: RegistryKey<DimensionOptions?> = RegistryKey.of(RegistryKeys.DIMENSION, ABYSS_ID)
    val ABYSS_WORLD: RegistryKey<World?> = RegistryKey.of(RegistryKeys.WORLD, ABYSS_ID)

    fun init() {}

    fun bootstrapType(c: BootstrapContext<DimensionType?>) {
        c.register(
            ABYSS_TYPE,
            DimensionType(
                OptionalLong.empty(),
                false,
                false,
                false,
                false,
                1.0,
                false,
                false,
                -256,
                512,
                510,
                BlockTags.INFINIBURN_OVERWORLD,
                DimensionTypes.THE_NETHER_ID,
                0.0f,
                MonsterSettings(false, true, UniformIntProvider.create(0, 7), 0)
            )
        )
    }
}
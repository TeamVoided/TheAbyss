package org.teamvoided.theabyss.world.biome

import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeEffects
import net.minecraft.world.biome.GenerationSettings
import net.minecraft.world.biome.SpawnSettings
import net.minecraft.world.gen.BootstrapContext
import net.minecraft.world.gen.feature.DefaultBiomeFeatures
import org.teamvoided.theabyss.Abyss.id


@Suppress("MemberVisibilityCanBePrivate")
object AbyssBiomes {
    val TEST_ID = id("test")
    val TEST_BIOME: RegistryKey<Biome?> = RegistryKey.of(RegistryKeys.BIOME, TEST_ID)
    fun init() {}
    fun boostrap(context: BootstrapContext<Biome?>) {
        context.register(TEST_BIOME, testBiome(context))

    }

    fun testBiome(context: BootstrapContext<Biome?>): Biome? {
        val spawnSettings = SpawnSettings.Builder()
        DefaultBiomeFeatures.addSnowyMobs(spawnSettings)

        val genSettings = GenerationSettings.Builder(
            context.lookup(RegistryKeys.PLACED_FEATURE),
            context.lookup(RegistryKeys.CONFIGURED_CARVER)
        )

        DefaultBiomeFeatures.addWaterBiomeOakTrees(genSettings)

        return Biome.Builder()
            .downfall(1F)
            .temperature(1F)
            .effects(
                BiomeEffects.Builder()
                    .grassColor(0xffffff)
                    .fogColor(0xffffff)
                    .foliageColor(0xffffff)
                    .waterColor(0xffffff)
                    .waterFogColor(0xffffff)
                    .skyColor(0xffffff)
                    .build()
            )
            .generationSettings(genSettings.build())
            .spawnSettings(spawnSettings.build())
            .build()
    }

}
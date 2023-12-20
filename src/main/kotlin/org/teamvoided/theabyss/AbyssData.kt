package org.teamvoided.theabyss

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistrySetBuilder
import org.teamvoided.theabyss.Abyss.log
import org.teamvoided.theabyss.data.gen.AbyssWorldGenerator
import org.teamvoided.theabyss.world.biome.AbyssBiomes
import org.teamvoided.theabyss.world.dimension.AbyssDimension

@Suppress("unused")
object AbyssData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        log.info("Hello from DataGen")
        val pack = gen.createPack()

        pack.addProvider(::AbyssWorldGenerator)
    }


    override fun buildRegistry(gen: RegistrySetBuilder) {
        gen.add(RegistryKeys.BIOME, AbyssBiomes::boostrap)
        gen.add(RegistryKeys.DIMENSION_TYPE, AbyssDimension::bootstrapType)
    }
}
package org.teamvoided.theabyss

import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.teamvoided.theabyss.world.biome.AbyssBiomes
import org.teamvoided.theabyss.world.dimension.AbyssDimension

@Suppress("unused")
object Abyss {
    const val MODID = "abyssal_depths"
    @JvmField
    val log: Logger = LoggerFactory.getLogger(Abyss::class.simpleName)

    fun commonInit() {
        log.info("Hello from Common")
        AbyssDimension.init()
        AbyssBiomes.init()
    }

    fun clientInit() {
        log.info("Hello from Client")
    }

    fun id(path: String) = Identifier(MODID, path)
}

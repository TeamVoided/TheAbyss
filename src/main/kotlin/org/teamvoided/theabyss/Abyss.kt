package org.teamvoided.theabyss

import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

@Suppress("unused")
object Abyss {
    const val MODID = "template"

    @JvmField
    val LOGGER = LoggerFactory.getLogger(Abyss::class.java)

    fun commonInit() {
        LOGGER.info("Hello from Common")
    }

    fun clientInit() {
        LOGGER.info("Hello from Client")
    }

    fun id(path: String) = Identifier(MODID, path)
}

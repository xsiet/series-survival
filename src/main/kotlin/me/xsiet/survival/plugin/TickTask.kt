package me.xsiet.survival.plugin

import me.xsiet.survival.Bio
import me.xsiet.survival.SurvivalConfig
import me.xsiet.survival.Survival
import io.github.monun.tap.fake.FakeEntityServer
import java.io.File
import java.util.logging.Logger

class TickTask(
    private val logger: Logger,
    private val configFile: File,
    private val fakeEntityServerForZombie: FakeEntityServer,
    private val fakeEntityServerForHuman: FakeEntityServer,
    private val survival: Survival
): Runnable {
    private var configFileLastModified = configFile.lastModified()
    override fun run() {
        survival.players.forEach {
            it.update()
        }
        Bio.SuperZombie.updateTarget()
        fakeEntityServerForZombie.update()
        fakeEntityServerForHuman.update()
        if (configFileLastModified != configFile.lastModified()) {
            SurvivalConfig.load(configFile)
            configFileLastModified = configFile.lastModified()
            survival.players.forEach { it.bio.applyAttribute() }
            logger.info("Config reloaded")
        }
    }
}
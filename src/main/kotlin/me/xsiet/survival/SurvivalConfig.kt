package me.xsiet.survival

import io.github.monun.tap.config.Config
import io.github.monun.tap.config.ConfigSupport
import org.bukkit.Material
import java.io.File
import java.util.*

object SurvivalConfig {
    @Config
    var bootsFallSlow = 4
    @Config
    var bootsFallDamage = 6.0
    @Config
    var summonDurationTime = 20000L
    @Config
    var spectorDurationTick = 200
    @Config
    var summonCount = 3
    @Config
    var spectorCooldownTick = 20L * 60L * 1L
    @Config
    var summonSuperZombieCooldownTick = 20L * 60L * 30L
    @Config
    var summonCooldownTick = 20L * 60L * 5L
    @Config
    var worldSize = 4096.0
    @Config
    var humanHealth = 20.0
    @Config
    var zombieHealth = 20.0
    @Config
    var superZombieHealth = 20.0
    @Config
    var hyperZombieJumpAmplifier = 12
    @Config
    var hyperZombieJumpTick = 50
    @Config
    var hyperZombieDamage = 2.0
    @Config
    var hyperZombieSpeed = 0.3
    @Config
    var hyperZombieHealth = 40.0
    @Config
    var witherAmplifier = 0
    @Config
    var witherDuration = 100
    @Config
    var zombieDamage = 0.5
    @Config
    var zombieItemDrop = 0.5
    @Config
    var defaultHumanList = arrayListOf(
        "heptagram",
        "Men1",
        "ehdgh141",
        "shalitz",
        "_BISE",
        "Ideon_97",
        "_nong_",
        "aringga",
        "youran6471",
        "j2_mong",
        "I_6ix",
        "ryu_96",
        "komq",
        "lotear",
        "Kin_A",
        "9oo9oo",
        "lleeshin",
        "0hoonida"
    )
    @Config
    var defaultSuperZombieList = arrayListOf(
        "heptagram",
        "ehdgh141",
        "komq"
    )
    @Config
    var zombieUncraftableList = listOf(
        Material.SHIELD,
        Material.LEATHER_CHESTPLATE,
        Material.LEATHER_BOOTS,
        Material.IRON_CHESTPLATE,
        Material.GOLDEN_CHESTPLATE,
        Material.GOLDEN_LEGGINGS,
        Material.IRON_BOOTS
    ).map { it.name }
    lateinit var defaultHumans: Set<String>
    lateinit var defaultSuperZombies: Set<String>
    lateinit var zombieUncraftables: EnumSet<Material>
    fun load(configFile: File) {
        ConfigSupport.compute(this, configFile)
        defaultHumans = defaultHumanList.map { it.trim() }.toSortedSet(String.CASE_INSENSITIVE_ORDER)
        defaultSuperZombies = defaultSuperZombieList.map { it.trim() }.toSortedSet(String.CASE_INSENSITIVE_ORDER)
        zombieUncraftables = EnumSet.copyOf(zombieUncraftableList.map { Material.valueOf(it.toUpperCase()) })
    }
}
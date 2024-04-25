package me.xsiet.survival.plugin

import io.github.monun.kommand.*
import io.github.monun.kommand.KommandArgument.Companion.dynamic
import me.xsiet.survival.Bio
import me.xsiet.survival.SurvivalItem
import me.xsiet.survival.survival
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object CommandSVL {
    internal fun register(plugin: SurvivalPlugin) {
        val bioArgument = dynamic { _, input ->
            Bio.Type.byKey(input)
        }.apply {
            suggests {
                Bio.Type.entries.forEach {
                    suggest(it.key)
                }
            }
        }
        plugin.kommand {
            register("svl") {
                requires {
                    isOp
                }
                then("attach") {
                    then("player" to players(), "bio" to bioArgument) {
                        executes {
                            val player: Collection<Player> by it
                            val bio: Bio.Type by it
                            attach(sender, player, bio)
                        }
                    }
                }
                then("vaccine") {
                    requires {
                        isPlayer
                    }
                    executes {
                        vaccine(sender, listOf(sender as Player))
                    }
                    then("player" to players()) {
                        executes {
                            val player: Collection<Player> by it
                            vaccine(sender, player)
                        }
                    }
                }
                then("hypervaccine") {
                    requires {
                        isPlayer
                    }
                    executes {
                        hyperVaccine(sender, listOf(sender as Player))
                    }
                    then("player" to players()) {
                        executes {
                            val player: Collection<Player> by it
                            hyperVaccine(sender, player)
                        }
                    }
                }
                then("resetcooldown") {
                    requires {
                        isPlayer
                    }
                    executes {
                        resetCooldown(sender, sender as Player)
                    }
                }
            }
        }
    }
    private fun attach(sender: CommandSender, players: Collection<Player>, bio: Bio.Type) {
        players.forEach {
            it.survival().setBio(bio)
            sender.sendMessage("${it.name} = ${bio.displayName}")
        }
    }
    private fun vaccine(sender: CommandSender, players: Collection<Player>) {
        players.forEach {
            it.inventory.addItem(SurvivalItem.vaccine.clone())
        }
        sender.sendMessage("백신을 지급했습니다.")
    }
    private fun hyperVaccine(sender: CommandSender, players: Collection<Player>) {
        players.forEach {
            it.inventory.addItem(SurvivalItem.hyperVaccine.clone())
        }
        sender.sendMessage("하이퍼 백신을 지급했습니다.")
    }
    private fun resetCooldown(sender: CommandSender, player: Player) {
        val survival = player.survival()
        val bio = survival.bio
        if (bio is Bio.Zombie) {
            bio.resetCooldown()
        }
        sender.sendMessage("Reset cooldown ${player.name}")
    }
}
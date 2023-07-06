package me.notzorba.actinium.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.*
import me.notzorba.actinium.Actinium
import me.notzorba.actinium.util.Chat
import me.notzorba.actinium.util.SpawnUtil
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import kotlin.math.abs

object SpawnCommands : BaseCommand() {

    fun dif(first: Double, second: Double): Boolean {
        return abs(first - second) > 0.500
    }

    @CommandAlias("setspawn")
    @CommandPermission("actinium.setspawn")
    fun setSpawn(sender: Player) {
        SpawnUtil.setSpawnLocation(sender.location)
        sender.sendMessage(Component.text("Set spawn to your current location.", NamedTextColor.GREEN))
    }

    @CommandAlias("spawn")
    fun spawn(sender: Player, @Optional @Name("target") @Flags("other") target: Player?) {
        val player = target ?: sender

        if (player != sender && !sender.hasPermission("actinium.spawn.others")) {
            sender.sendMessage(Component.text("You do not have permission!", NamedTextColor.RED))
            return
        }

        if (target != null) {
            sender.sendMessage(Chat.format("&aTeleported {${target.name} to spawn!"))
        }

        object : BukkitRunnable() {

            var remaining = Actinium.instance.config.getInt("spawn.delay")
            var location = player.location

            override fun run() {
                if (dif(location.x, player.location.x) || dif(location.y, player.location.y) || dif(location.z, player.location.z)) {
                    player.sendActionBar(Component.text("Teleport cancelled because you moved!", NamedTextColor.DARK_RED))
                    cancel()
                    return
                }
                if (remaining == 1) {
                    player.teleport(SpawnUtil.getSpawnLocation())
                    player.sendActionBar(Component.text("You were teleported to spawn.", NamedTextColor.GREEN))
                    cancel()
                    return
                }
                player.sendActionBar(Component.text("Teleporting in $remaining seconds. Do not move", NamedTextColor.GREEN))
            }
        }
    }
}
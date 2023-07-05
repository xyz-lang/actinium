package me.notzorba.actinium.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.*
import me.notzorba.actinium.util.Chat
import me.notzorba.actinium.util.SpawnUtil
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.entity.Player

object SpawnCommands : BaseCommand() {

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

        player.teleport(SpawnUtil.getSpawnLocation())
        player.sendMessage(Component.text("Teleported you to spawn.", NamedTextColor.GREEN))
    }
}
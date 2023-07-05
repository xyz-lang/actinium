package me.notzorba.actinium.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.*
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.GameMode
import org.bukkit.entity.Player

object Gamemode : BaseCommand() {

    @CommandAlias("gmc")
    @CommandPermission("actinium.gamemode.creative")
    fun gmc(sender: Player, @Optional @Flags("other") @Name("target") target: Player?) {

        val player = target ?: sender

        if (player != sender && !sender.hasPermission("actinium.gamemode.others")) {
            sender.sendMessage(Component.text("You do not have permission!", NamedTextColor.RED))
            return
        }
        if (target != null) {
            sender.sendMessage(Component.text("Set ${target.name}'s gamemode to creative", NamedTextColor.GREEN))
        }

        player.gameMode = GameMode.CREATIVE
        player.sendMessage(Component.text("Your gamemode has been set to creative", NamedTextColor.GREEN))
    }

    @CommandAlias("gms")
    @CommandPermission("actinium.gamemode.survival")
    fun gms(sender: Player, @Optional @Flags("other") @Name("target") target: Player?) {

        val player = target ?: sender

        if (player != sender && !sender.hasPermission("actinium.gamemode.others")) {
            sender.sendMessage(Component.text("You do not have permission!", NamedTextColor.RED))
            return
        }
        if (target != null) {
            sender.sendMessage(Component.text("Set ${target.name}'s gamemode to creative", NamedTextColor.GREEN))
        }

        player.gameMode = GameMode.SURVIVAL
        player.sendMessage(Component.text("Your gamemode has been set to survival", NamedTextColor.GREEN))
    }

    @CommandAlias("gmsp")
    @CommandPermission("actinium.gamemode.spectator")
    fun gmsp(sender: Player, @Optional @Flags("other") @Name("target") target: Player?) {

        val player = target ?: sender

        if (player != sender && !sender.hasPermission("actinium.gamemode.others")) {
            sender.sendMessage(Component.text("You do not have permission!", NamedTextColor.RED))
            return
        }
        if (target != null) {
            sender.sendMessage(Component.text("Set ${target.name}'s gamemode to creative", NamedTextColor.GREEN))
        }

        player.gameMode = GameMode.SPECTATOR
        player.sendMessage(Component.text("Your gamemode has been set to spectator", NamedTextColor.GREEN))
    }

    @CommandAlias("gma")
    @CommandPermission("actinium.gamemode.adventure")
    fun gma(sender: Player, @Optional @Flags("other") @Name("target") target: Player?) {

        val player = target ?: sender

        if (player != sender && !sender.hasPermission("actinium.gamemode.others")) {
            sender.sendMessage(Component.text("You do not have permission!", NamedTextColor.RED))
            return
        }
        if (target != null) {
            sender.sendMessage(Component.text("Set ${target.name}'s gamemode to creative", NamedTextColor.GREEN))
        }

        player.gameMode = GameMode.ADVENTURE
        player.sendMessage(Component.text("Your gamemode has been set to adventure", NamedTextColor.GREEN))
    }
}
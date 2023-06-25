package me.notzorba.actinium.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.Name
import co.aikar.commands.annotation.Optional
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.GameMode
import org.bukkit.entity.Player

object Gamemode : BaseCommand() {

    @CommandAlias("gmc")
    fun gmc(sender: Player, @Optional @Name("target") target: Player?){
        val player = target ?: sender
        player.gameMode = GameMode.CREATIVE
        player.sendMessage(Component.text("Your gamemode has been set to creative", NamedTextColor.GREEN))
        if(target != null){
            sender.sendMessage(Component.text("Set ${target.name}'s gamemode to creative", NamedTextColor.GREEN))
        }
    }

    @CommandAlias("gms")
    fun gms(sender: Player, @Optional @Name("target") target: Player?){
        val player = target ?: sender
        player.gameMode = GameMode.SURVIVAL
        player.sendMessage(Component.text("Your gamemode has been set to survival", NamedTextColor.GREEN))
        if(target != null){
            sender.sendMessage(Component.text("Set ${target.name}'s gamemode to survival", NamedTextColor.GREEN))
        }
    }

    @CommandAlias("gmsp")
    fun gmsp(sender: Player, @Optional @Name("target") target: Player?){
        val player = target ?: sender
        player.gameMode = GameMode.SPECTATOR
        player.sendMessage(Component.text("Your gamemode has been set to spectator", NamedTextColor.GREEN))
        if(target != null){
            sender.sendMessage(Component.text("Set ${target.name}'s gamemode to spectator", NamedTextColor.GREEN))
        }
    }

    @CommandAlias("gma")
    fun gma(sender: Player, @Optional @Name("target") target: Player?){
        val player = target ?: sender
        player.gameMode = GameMode.ADVENTURE
        player.sendMessage(Component.text("Your gamemode has been set to adventure", NamedTextColor.GREEN))
        if(target != null){
            sender.sendMessage(Component.text("Set ${target.name}'s gamemode to adventure", NamedTextColor.GREEN))
        }
    }

}
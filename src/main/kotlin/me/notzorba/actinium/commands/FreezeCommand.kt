package me.notzorba.actinium.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Flags
import co.aikar.commands.annotation.Name
import me.notzorba.actinium.handlers.FreezeHandler
import me.notzorba.actinium.util.Chat
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object FreezeCommand : BaseCommand() {

    @CommandAlias("freeze|ss")
    @CommandPermission("actinium.freeze")
    fun freeze(sender: Player, @Name("target") @Flags("other") target: Player) {

        if (FreezeHandler.isFrozen(target)) {
            FreezeHandler.frozenPlayers.remove(target.uniqueId)
            target.sendMessage(Chat.format("&aYou have been unfrozen"))
            Bukkit.getOnlinePlayers().filter { it.hasPermission("actinium.staff") }.forEach { it.sendMessage(Chat.format("&b[S] &f${target.name} &7has froze &f${target.name}")) }
            return
        }
        FreezeHandler.frozenPlayers.add(target.uniqueId)
        target.sendMessage(Chat.format("&cYou have been frozen"))
        Bukkit.getOnlinePlayers().filter { it.hasPermission("actinium.staff") }.forEach { it.sendMessage(Chat.format("&b[S] &f${target.name} &7has froze &f${target.name}")) }
    }
}
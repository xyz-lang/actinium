package me.notzorba.actinium.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Name
import me.notzorba.actinium.util.Chat
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object Broadcast : BaseCommand() {

    @CommandAlias("broadcast")
    @CommandPermission("command.announce")
    fun broadcast(sender: Player, @Name("message") message: String) {
        Bukkit.broadcastMessage("")
        Bukkit.broadcastMessage(Chat.format("&#ff1000&lANNOUNCEMENT"))
        Bukkit.broadcastMessage("")
        Bukkit.broadcastMessage(Chat.format("&7${message}"))
        Bukkit.broadcastMessage("")
    }
}
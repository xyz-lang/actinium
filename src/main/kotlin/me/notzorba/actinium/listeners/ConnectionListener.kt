package me.notzorba.actinium.listeners

import me.notzorba.actinium.util.Chat
import me.notzorba.actinium.util.SpawnUtil
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

object ConnectionListener : Listener {

    @EventHandler
    fun join(e: PlayerJoinEvent) {
        e.joinMessage(Component.text("${e.player.name} has joined!", NamedTextColor.GRAY).decorate(TextDecoration.ITALIC))
        e.player.teleport(SpawnUtil.getSpawnLocation())
    }

    @EventHandler
    fun quit(e: PlayerQuitEvent) {
        e.quitMessage = null
        Bukkit.getOnlinePlayers().filter { it.hasPermission("actinium.staff") }.forEach { it.sendMessage(Chat.format("&c&l- &7${e.player.name}")) }
    }
}
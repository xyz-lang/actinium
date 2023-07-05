package me.notzorba.actinium.listeners

import co.aikar.commands.ACFBukkitHelpTopic
import me.notzorba.actinium.Actinium
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
        e.joinMessage = null
        if (e.player.hasPlayedBefore()) {
            Bukkit.broadcastMessage(Chat.format(Actinium.instance.config.getString("messages.join")?.replace("%player%", e.player.name)!!))
            if (Actinium.instance.config.getBoolean("spawn.teleport-to-spawn-on-join")) {
                e.player.teleport(SpawnUtil.getSpawnLocation())
            }
        } else {
            Bukkit.broadcastMessage(Chat.format(Actinium.instance.config.getString("messages.firstjoin")?.replace("%player%", e.player.name)!!))
            e.player.teleport(SpawnUtil.getSpawnLocation())
        }
    }

    @EventHandler
    fun quit(e: PlayerQuitEvent) {
        e.quitMessage = null
        Bukkit.getOnlinePlayers().filter { it.hasPermission("actinium.staff") }.forEach { it.sendMessage(Chat.format(Actinium.instance.config.getString("messages.quit")!!)) }
    }
}
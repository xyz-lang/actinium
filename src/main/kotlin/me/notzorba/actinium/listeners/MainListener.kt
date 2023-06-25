package me.notzorba.actinium.listeners

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

object MainListener : Listener {

    @EventHandler
    fun join(e: PlayerJoinEvent){
        e.joinMessage(Component.text("${e.player.name} has joined!", NamedTextColor.GRAY).decorate(TextDecoration.ITALIC))
        if(!e.player.hasPlayedBefore()){

        }
    }
}
package me.notzorba.actinium.listeners

import io.papermc.paper.event.block.BlockBreakBlockEvent
import me.notzorba.actinium.handlers.FreezeHandler
import me.notzorba.actinium.util.Chat
import org.bukkit.Location
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.player.PlayerMoveEvent


object FrozenPlayerListener : Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    fun move(e: PlayerMoveEvent) {
        if (FreezeHandler.isFrozen(e.player)) {
            val from: Location = e.from
            val to: Location = e.to
            if (from.x != to.x || e.from.z != e.to.z) {
                val newLocation: Location = from.block.location.add(0.5, 0.0, 0.5)
                newLocation.pitch = to.pitch
                newLocation.yaw = to.yaw
                e.to = newLocation
            }
        }
    }

    @EventHandler
    fun damage(e: EntityDamageByEntityEvent) {
        val entity = e.entity

        if (entity is Player) {
            if (FreezeHandler.isFrozen(entity)) {
                val damager = e.damager

                damager.sendMessage(Chat.format("&cThat player is frozen and can not be damaged"))
                e.isCancelled = true
            }
        }
    }

    @EventHandler
    fun damageEntity(e: EntityDamageByEntityEvent) {
        val entity = e.damager

        if (entity is Player) {
            if (FreezeHandler.isFrozen(entity)) {
                entity.sendMessage(Chat.format("&cYou cannot damage others while frozen"))
                e.isCancelled = true
            }
        }
    }

    @EventHandler
    fun blockBreak(e: BlockBreakEvent) {
        if (FreezeHandler.isFrozen(e.player)) {
            e.player.sendMessage(Chat.format("&cYou cannot break blocks while frozen"))
            e.isCancelled = true
        }
    }

    @EventHandler
    fun blockPlace(e: BlockPlaceEvent) {
        if (FreezeHandler.isFrozen(e.player)) {
            e.player.sendMessage(Chat.format("&cYou cannot place blocks while frozen"))
            e.isCancelled = true
        }
    }
}
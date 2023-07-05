package me.notzorba.actinium.handlers

import org.bukkit.entity.Player
import java.util.UUID

object FreezeHandler {

    val frozenPlayers = mutableListOf<UUID>()

    fun isFrozen(player: Player) : Boolean {
        return frozenPlayers.contains(player.uniqueId)
    }
}
package me.notzorba.actinium.handlers

import org.bukkit.entity.Player
import java.util.*
import java.util.concurrent.TimeUnit


object ReportHandler {
    val reportCooldowns = mutableMapOf<UUID, Long>()

    fun isOnReportCooldown(player: Player) : Boolean
    {
        if (!reportCooldowns.containsKey(player.uniqueId)) return false

        val value = reportCooldowns[player.uniqueId]!!

        return (System.currentTimeMillis().minus(value) <= TimeUnit.MINUTES.toMillis(1L))
    }
}
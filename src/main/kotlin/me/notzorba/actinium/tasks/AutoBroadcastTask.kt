package me.notzorba.actinium.tasks

import me.notzorba.actinium.Actinium
import me.notzorba.actinium.util.Chat
import org.bukkit.Bukkit
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.scheduler.BukkitRunnable

object AutoBroadcastTask : BukkitRunnable() {

    var i = 0

    val announcements: MutableList<String> = mutableListOf()

    fun load(config: FileConfiguration) {
        announcements.clear()

        for (i in 0 until config.getStringList("autobroadcast.announcements").size) {
            announcements.add(config.getStringList("autobroadcast.announcements")[i].replace("%nl%", "\n"))
        }

        runTaskTimer(Actinium.instance, 20L, config.getInt("autobroadcast.delay").toLong() * 20)
    }

    override fun run() {
        val message = announcements[i]

        Bukkit.broadcastMessage(Chat.format(Actinium.instance.config.getString("autobroadcast.prefix") + message))

        if (i == announcements.size - 1) {
            i = 0
        } else {
            i++
        }
    }
}
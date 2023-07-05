package me.notzorba.actinium

import co.aikar.commands.PaperCommandManager
import me.notzorba.actinium.commands.*
import me.notzorba.actinium.listeners.ConnectionListener
import me.notzorba.actinium.tasks.AutoBroadcastTask
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Actinium : JavaPlugin() {

    companion object {
        lateinit var instance: Actinium
    }

    override fun onEnable() {
        this.saveDefaultConfig()
        instance = this

        val commandManager = PaperCommandManager(this)

        commandManager.registerCommand(Gamemode)
        commandManager.registerCommand(Broadcast)
        commandManager.registerCommand(Spawn)
        commandManager.registerCommand(Teleport)
        commandManager.registerCommand(Reload)
        Bukkit.getPluginManager().registerEvents(ConnectionListener, this)
        AutoBroadcastTask.load(config)
    }
}
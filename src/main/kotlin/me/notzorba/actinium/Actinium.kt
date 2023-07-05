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

        commandManager.registerCommand(GamemodeCommands)
        commandManager.registerCommand(BroadcastCommand)
        commandManager.registerCommand(SpawnCommands)
        commandManager.registerCommand(TeleportCommands)
        commandManager.registerCommand(ReloadCommand)
        commandManager.registerCommand(DiscordCommand)
        commandManager.registerCommand(HealCommands)
        commandManager.registerCommand(ReportCommand)
        commandManager.registerCommand(FreezeCommand)
        Bukkit.getPluginManager().registerEvents(ConnectionListener, this)
        AutoBroadcastTask.load(config)
    }
}
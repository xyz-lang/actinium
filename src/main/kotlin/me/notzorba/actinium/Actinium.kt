package me.notzorba.actinium

import co.aikar.commands.PaperCommandManager
import me.notzorba.actinium.commands.Gamemode
import me.notzorba.actinium.listeners.MainListener
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

        Bukkit.getPluginManager().registerEvents(MainListener, this)
    }
}
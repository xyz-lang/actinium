package me.notzorba.actinium.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import org.bukkit.entity.Player

object Spawn : BaseCommand() {

    @CommandAlias("setspawn")
    @CommandPermission("command.setspawn")
    fun setspawn(sender: Player){

    }
}
package me.notzorba.actinium.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Subcommand
import me.notzorba.actinium.Actinium
import me.notzorba.actinium.tasks.AutoBroadcastTask
import me.notzorba.actinium.util.Chat
import org.bukkit.entity.Player

@CommandAlias("actinium")
@CommandPermission("actinium.reload")
object ReloadCommand : BaseCommand() {

    @Subcommand("reload")
    fun reload(sender: Player) {

        Actinium.instance.reloadConfig()
        AutoBroadcastTask.load(Actinium.instance.config)
        sender.sendMessage(Chat.format("&aReloaded config"))
    }
}
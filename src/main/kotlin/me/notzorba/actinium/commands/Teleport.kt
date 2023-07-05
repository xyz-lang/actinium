package me.notzorba.actinium.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Flags
import co.aikar.commands.annotation.Name
import co.aikar.commands.annotation.Optional
import me.notzorba.actinium.util.Chat
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object Teleport : BaseCommand() {

    @CommandAlias("tp|teleport")
    @CommandPermission("actinium.teleport")
    fun teleport(sender: Player, @Name("target") @Flags("other") target: Player, @Optional @Flags("other") @Name("targett") targett: Player?) {

        if (targett != null && !sender.hasPermission("actinium.teleport.others")) {
            sender.sendMessage(Component.text("You do not have permission!", NamedTextColor.RED))
            return
        } else if (targett != null) {
            target.teleport(targett.getLocation())
            sender.sendMessage(Component.text("Teleported ${target.name} to ${targett.name}", NamedTextColor.GREEN))
            return
        }

        sender.teleport(target.getLocation())
        sender.sendMessage(Component.text("Teleported you to ${target.name}", NamedTextColor.GREEN))
    }

    @CommandAlias("tphere|teleporthere")
    @CommandPermission("actinium.teleport.others")
    fun telportOthers(sender: Player, @Name("target") @Flags("other") target: Player) {

        target.teleport(sender.getLocation())
        sender.sendMessage(Component.text("Teleported ${target.name} to you", NamedTextColor.GREEN))
    }

    @CommandAlias("tpall")
    @CommandPermission("actinium.tpall")
    fun teleportAll(sender: Player) {

        Bukkit.getOnlinePlayers().forEach {  it.teleport(sender.getLocation()) }
        sender.sendMessage(Chat.format("&aTeleproted all online players to you!"))
    }
}
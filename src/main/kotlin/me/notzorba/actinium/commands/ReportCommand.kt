package me.notzorba.actinium.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.Flags
import co.aikar.commands.annotation.Name
import me.notzorba.actinium.handlers.ReportHandler
import me.notzorba.actinium.util.Chat
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.ComponentLike
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.event.HoverEvent
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.Bukkit
import org.bukkit.entity.Player

object ReportCommand : BaseCommand() {

    @CommandAlias("report")
    fun report(sender: Player, @Name("target") target: Player, @Name("reason") @Flags("other") reason: String) {

        if (ReportHandler.isOnReportCooldown(sender)) {
            sender.sendMessage(Chat.format("&cYou are on report cooldown."))
            return
        }

        if (sender.name == target.name) {
            sender.sendMessage(Chat.format("&cYou can not report yourself"))
            return
        }

        val reportMessage = Component.text()
            .append(Component.text("[Report] ", NamedTextColor.BLUE))
            .append(Component.text(sender.name, NamedTextColor.AQUA))
            .append(Component.text(" has reported ", NamedTextColor.GRAY))
            .append(Component.text(target.name, NamedTextColor.AQUA))
            .append(Component.newline())
            .append(Component.text("    Reason: ", NamedTextColor.BLUE))
            .append(Component.text(reason, NamedTextColor.GRAY))
            .hoverEvent(HoverEvent.showText(Component.text("Click to teleport", NamedTextColor.GREEN)))
            .clickEvent(ClickEvent.runCommand("/tp ${target.name}"))

        Bukkit.getOnlinePlayers().filter { it.hasPermission("actinium.staff") }.forEach { player ->
            player.sendMessage(reportMessage)
        }
        ReportHandler.reportCooldowns[sender.uniqueId] = System.currentTimeMillis()
    }
}
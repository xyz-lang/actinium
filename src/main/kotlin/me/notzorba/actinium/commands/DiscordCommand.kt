package me.notzorba.actinium.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import me.notzorba.actinium.Actinium
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.event.ClickEvent
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import org.bukkit.entity.Player

object DiscordCommand : BaseCommand() {

    @CommandAlias("discord|dc")
    fun discord(sender: Player) {
        val message = Actinium.instance.config.getString("discord.message")!!
        val link = Actinium.instance.config.getString("discord.link")!!

        val serializer = LegacyComponentSerializer.legacyAmpersand()
        val formattedMessage = serializer.deserialize(message)

        val clickableMessage = formattedMessage.clickEvent(ClickEvent.clickEvent(ClickEvent.Action.OPEN_URL, link))

        sender.sendMessage(clickableMessage)
    }
}
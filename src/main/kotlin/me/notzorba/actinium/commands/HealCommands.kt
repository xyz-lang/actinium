package me.notzorba.actinium.commands

import co.aikar.commands.BaseCommand
import co.aikar.commands.annotation.CommandAlias
import co.aikar.commands.annotation.CommandPermission
import co.aikar.commands.annotation.Flags
import co.aikar.commands.annotation.Name
import co.aikar.commands.annotation.Optional
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player

object HealCommands : BaseCommand() {

    @CommandAlias("heal")
    @CommandPermission("actinium.heal")
    fun heal(sender: Player, @Optional @Name("target") @Flags("other") target: Player?) {

        val player = target ?: sender

        if (target != null) {
            sender.sendMessage(Component.text("${target.name} has been healed!", NamedTextColor.GREEN))
        }

        player.health = player.getAttribute(Attribute.GENERIC_MAX_HEALTH)?.value ?: 20.0
        player.fireTicks = 0
        player.foodLevel = 20
        player.freezeTicks = 0
        player.sendMessage(Component.text("You have been healed!", NamedTextColor.GREEN))
    }

    @CommandAlias("feed|eat")
    @CommandPermission("actinium.feed")
    fun feed(sender: Player, @Optional @Name("target") @Flags("other") target: Player?) {

        val player = target ?: sender

        if (target != null) {
            sender.sendMessage(Component.text("${target.name} has been fed!", NamedTextColor.GREEN))
        }

        player.saturation = 20f
        player.foodLevel = 20
        player.sendMessage(Component.text("You have been fed!", NamedTextColor.GREEN))
    }
}
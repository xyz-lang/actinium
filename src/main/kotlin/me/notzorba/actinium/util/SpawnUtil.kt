package me.notzorba.actinium.util

import me.notzorba.actinium.Actinium
import org.bukkit.Bukkit
import org.bukkit.Location


object SpawnUtil {

    fun getSpawnLocation(): Location{
        val config = Actinium.instance.config
        val world = Bukkit.getWorld(config.getString("spawn.world")!!)
        val x = config.getDouble("spawn.x")
        val y = config.getDouble("spawn.y")
        val z = config.getDouble("spawn.z")
        val pitch = config.getDouble("spawn.pitch").toFloat()
        val yaw = config.getDouble("spawn.yaw").toFloat()

        return Location(world, x, y, z, yaw, pitch)
    }

    fun setSpawnLocation(location: Location){
        val config = Actinium.instance.config
        val world = location.world
        val x = location.x
        val y = location.y
        val z = location.z
        val pitch = location.pitch
        val yaw = location.yaw
        Actinium.instance.config.apply {
            set("spawn.world", world)
            set("spawn.x", x)
            set("spawn.y", y)
            set("spawn.z", z)
            set("spawn.pitch", pitch)
            set("spawn.yaw", yaw)
        }
    }
}
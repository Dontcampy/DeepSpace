package com.dont39.deepspace.core

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.minecraft.network.MessageType
import net.minecraft.text.TranslatableText
import net.minecraft.util.Util
import org.apache.logging.log4j.LogManager

@Suppress("unused")
fun init() {
  // This code runs as soon as Minecraft is in a mod-load-ready state.
  // However, some things (like resources) may still be uninitialized.
  // Proceed with mild caution.
  Init().init()
  ServerTickEvents.END_SERVER_TICK.register(ServerTickEvents.EndTick {
    if (it.ticks % 100 == 0) {
      it.playerManager.broadcastChatMessage(TranslatableText("text.deepspace.core.hw"), MessageType.GAME_INFO, Util.NIL_UUID)
    }
  })
}

class Init {
  private val logger = LogManager.getLogger(javaClass)
  fun init() {
    logger.info("Hello Deep space.")
  }
}
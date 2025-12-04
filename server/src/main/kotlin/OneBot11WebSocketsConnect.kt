package tech.kotlinhero.onebot11.server

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.*
import io.ktor.server.application.*
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.launch

fun Application.connectToOneBotWebSockets() {
    launch {
        val client = HttpClient(CIO) {
            install(WebSockets)
        }
        client.webSocket(
            host = "127.0.0.1",
            port = 3001,
            path = "/"
        ) {
            for (frame in incoming) {
                when (frame) {
                    is Frame.Text -> {
                        println(frame.readText())
                    }

                    else -> {

                    }
                }
            }
        }
    }
}
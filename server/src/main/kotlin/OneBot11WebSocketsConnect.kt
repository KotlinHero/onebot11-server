package tech.kotlinhero.onebot11.server

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.*
import io.ktor.server.application.*
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import tech.kotlinhero.onebot11.post.Event
import tech.kotlinhero.onebot11.post.MessageEvent
import tech.kotlinhero.onebot11.post.TextMessage

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
                        when (val event: Event = Json.decodeFromString(frame.readText())) {
                            is MessageEvent -> {
                                println(event.userId)
                                when (val message = event.message.first()) {
                                    is TextMessage -> {
                                        println(message.data.text)
                                    }

                                    else -> {}
                                }
                            }

                            else -> {}
                        }
                    }

                    else -> {

                    }
                }
            }
        }
    }
}
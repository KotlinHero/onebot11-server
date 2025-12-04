package tech.kotlinhero.onebot11.client.ktor

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.webSocket
import io.ktor.websocket.Frame
import io.ktor.websocket.readText
import kotlinx.coroutines.runBlocking

fun main() {

    val client = HttpClient(CIO) {
        install(WebSockets)
    }

    runBlocking {
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
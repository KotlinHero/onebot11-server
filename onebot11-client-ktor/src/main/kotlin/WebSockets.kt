package tech.kotlinhero.onebot11.client.ktor

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.*
import io.ktor.websocket.WebSocketSession

suspend fun webSocketConnectTo(
    host: String,
    port: Int,
    block: suspend OneBot11KtorWebSocketClient.() -> Unit
) {
    HttpClient(CIO) {
        install(WebSockets)
    }.use { client ->
        client.webSocket(
            host = host,
            port = port,
            path = "/"
        ) {
            OneBot11KtorWebSocketClient(this).block()
        }
    }
}
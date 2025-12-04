package tech.kotlinhero.onebot11.client.ktor

import tech.kotlinhero.onebot11.client.api.OneBot11WebSocketClient
import tech.kotlinhero.onebot11.post.event.MessageEvent

class OneBot11KtorWebSocketClient : OneBot11WebSocketClient {

    private val messageEventHandlers = mutableListOf<(MessageEvent) -> Unit>()

    override fun receiveMessage(eventHandler: (MessageEvent) -> Unit) {
        messageEventHandlers.add(eventHandler)
    }

    override suspend fun connect() {
        TODO("Not yet implemented")
    }
}
package tech.kotlinhero.onebot11.client.api

import tech.kotlinhero.onebot11.client.api.event.MessageEvent

interface OneBot11WebSocketClient : OneBot11Client {
    fun receiveMessage(eventHandler: (MessageEvent) -> Unit)
}
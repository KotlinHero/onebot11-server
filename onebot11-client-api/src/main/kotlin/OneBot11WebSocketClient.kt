package tech.kotlinhero.onebot11.client.api

import tech.kotlinhero.onebot11.client.api.event.MessageEvent

interface OneBotWebSocketClient : OneBot11Client {
    fun receiveMessage(eventHandler: (MessageEvent) -> Unit)
}
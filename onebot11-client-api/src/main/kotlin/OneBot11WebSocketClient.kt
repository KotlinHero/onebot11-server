package tech.kotlinhero.onebot11.client.api

import tech.kotlinhero.onebot11.post.event.Event


interface OneBot11WebSocketClient : OneBot11Client {
    suspend fun receive(eventHandler: suspend (event: Event) -> Unit)
}
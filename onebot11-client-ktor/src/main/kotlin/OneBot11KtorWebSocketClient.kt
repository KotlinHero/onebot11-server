package tech.kotlinhero.onebot11.client.ktor

import io.ktor.client.plugins.websocket.*
import io.ktor.websocket.*
import tech.kotlinhero.onebot11.client.api.OneBot11WebSocketClient
import tech.kotlinhero.onebot11.client.api.request.OneBot11Request
import tech.kotlinhero.onebot11.client.api.request.encodeToString
import tech.kotlinhero.onebot11.client.api.request.setGroupBanRequest
import tech.kotlinhero.onebot11.post.event.Event
import tech.kotlinhero.onebot11.post.serialization.deserializeToEvent

typealias EventHandler = suspend (event: Event) -> Unit

class OneBot11KtorWebSocketClient(
    private val session: DefaultClientWebSocketSession,
) : OneBot11WebSocketClient, ClientWebSocketSession by session {

    override suspend fun setGroupBan(groupId: Long, userId: Long, duration: Long) {
        setGroupBanRequest(groupId, userId, duration).send()
    }

    override suspend fun receive(eventHandler: EventHandler) {
        for (frame in incoming) {
            if (frame is Frame.Text) {
                try {
                    val event = frame.readText().deserializeToEvent()
                    eventHandler(event)
                } catch (e : Exception) {

                }
            }
        }
    }

    private suspend inline fun <reified T : OneBot11Request> T.send() {
        send(this.encodeToString())
    }
}
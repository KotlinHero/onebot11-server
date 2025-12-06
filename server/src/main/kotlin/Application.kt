package tech.kotlinhero.onebot11.server

import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.websocket.send
import kotlinx.coroutines.launch
import tech.kotlinhero.onebot11.client.api.request.encodeToString
import tech.kotlinhero.onebot11.client.api.request.setGroupBanRequest
import tech.kotlinhero.onebot11.client.ktor.webSocketConnectTo
import tech.kotlinhero.onebot11.post.event.MessageEvent

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    initFtjGroupMessageRepeatMuter()
}

fun Application.initFtjGroupMessageRepeatMuter() {
    launch {
        webSocketConnectTo(
            host = "127.0.0.1",
            port = 3001
        ) {
            val repeatChecker = ftjGroupRepeatChecker(targetGroups = listOf(148100756, 312468793))
            receive { event ->
                if (event is MessageEvent) {
                    repeatChecker.checkRepeat(event) {
                        event.groupId?.let {
                            setGroupBan(it, event.userId, 60 * 2)
                            println("禁言${event.userId}")
                        }
                    }
                }
            }










        }
    }
}
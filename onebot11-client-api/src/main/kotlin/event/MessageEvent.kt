package tech.kotlinhero.onebot11.client.api.event

import java.time.LocalDateTime

data class MessageEvent(
    val time: LocalDateTime,
    val selfId: Long,
    val userId: Long? = null,
    val groupId: Long? = null
)

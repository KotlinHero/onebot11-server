package tech.kotlinhero.onebot11.post.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import tech.kotlinhero.onebot11.post.MessageType
import tech.kotlinhero.onebot11.post.serialization.MessageTypeSerializer
import tech.kotlinhero.onebot11.post.serialization.MillisToLocalDateTimeSerializer
import java.time.LocalDateTime


sealed interface MessageEvent {

    @Serializable
    sealed class GroupTextMessageEvent(
        @SerialName("self_id")
        val selfId: Long,

        @SerialName("user_id")
        val userId: Long,

        @Serializable(with = MillisToLocalDateTimeSerializer::class)
        val time: LocalDateTime,

        @SerialName("group_id")
        val groupId: Long? = null,

        @SerialName("message_type")
        @Serializable(with = MessageTypeSerializer::class)
        val messageType: MessageType
    ) : MessageEvent {
        data class Sender(
            @SerialName("user_id")
            val userId: Long,
            val nickname: String,
            val card: String,
            val role: String,
        )
    }
}
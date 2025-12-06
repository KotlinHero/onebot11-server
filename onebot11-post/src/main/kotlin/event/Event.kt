package tech.kotlinhero.onebot11.post.event

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator
import kotlinx.serialization.json.JsonIgnoreUnknownKeys
import tech.kotlinhero.onebot11.post.message.Message
import tech.kotlinhero.onebot11.post.message.MessageSubType
import tech.kotlinhero.onebot11.post.message.MessageSubTypeSerializer
import tech.kotlinhero.onebot11.post.message.MessageType
import tech.kotlinhero.onebot11.post.serialization.EventPostTypeSerializer
import tech.kotlinhero.onebot11.post.serialization.MessageTypeSerializer
import tech.kotlinhero.onebot11.post.serialization.MillisToLocalDateTimeSerializer
import java.time.LocalDateTime

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("post_type")
sealed interface Event


@OptIn(ExperimentalSerializationApi::class)
@SerialName("message")
@Serializable
@JsonIgnoreUnknownKeys
data class MessageEvent(
    @Serializable(MillisToLocalDateTimeSerializer::class)
    val time: LocalDateTime,

    @SerialName("self_id")
    val selfId: Long,

    @SerialName("post_type")
    @Serializable(EventPostTypeSerializer::class)
    val postType: EventPostType,

    @SerialName("message_id")
    val messageId: Long,

    @SerialName("message_seq")
    val messageSeq: Long,

    @SerialName("user_id")
    val userId: Long,

    @SerialName("group_id")
    val groupId: Long? = null,

    @SerialName("message_type")
    @Serializable(MessageTypeSerializer::class)
    val messageType: MessageType,

    @SerialName("sub_type")
    @Serializable(MessageSubTypeSerializer::class)
    val subType: MessageSubType,

    val sender: Sender,

    val message: List<Message>,

    @SerialName("raw_message")
    val rawMessage: String,

    ) : Event {
    @Serializable
    data class Sender(
        @SerialName("user_id")
        val userId: Long,

        val nickname: String,
        val card: String,
        val role: String,
        val title: String,
    )
}

@OptIn(ExperimentalSerializationApi::class)
@SerialName("meta_event")
@Serializable
@JsonIgnoreUnknownKeys
class MetaEvent(
    @Serializable(MillisToLocalDateTimeSerializer::class)
    val time: LocalDateTime,

    @SerialName("post_type")
    @Serializable(EventPostTypeSerializer::class)
    val postType: EventPostType
) : Event

@OptIn(ExperimentalSerializationApi::class)
@SerialName("notice")
@Serializable
@JsonIgnoreUnknownKeys
class NoticeEvent(
    @Serializable(MillisToLocalDateTimeSerializer::class)
    val time: LocalDateTime,

    @SerialName("post_type")
    @Serializable(EventPostTypeSerializer::class)
    val postType: EventPostType
) : Event


@OptIn(ExperimentalSerializationApi::class)
@SerialName("request")
@Serializable
@JsonIgnoreUnknownKeys
class RequestEvent(
    @Serializable(MillisToLocalDateTimeSerializer::class)
    val time: LocalDateTime,

    @SerialName("post_type")
    @Serializable(EventPostTypeSerializer::class)
    val postType: EventPostType
) : Event

@OptIn(ExperimentalSerializationApi::class)
@SerialName("")
@Serializable
@JsonIgnoreUnknownKeys
class JsonEvent(
    @Serializable(MillisToLocalDateTimeSerializer::class)
    val time: LocalDateTime,

    @SerialName("post_type")
    @Serializable(EventPostTypeSerializer::class)
    val postType: EventPostType
) : Event
package tech.kotlinhero.onebot11.post

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator
import tech.kotlinhero.onebot11.post.serialization.EventPostTypeSerializer
import tech.kotlinhero.onebot11.post.serialization.MillisToLocalDateTimeSerializer
import java.time.LocalDateTime

@OptIn(ExperimentalSerializationApi::class)
@Serializable
@JsonClassDiscriminator("post_type")
sealed interface Event

@OptIn(ExperimentalSerializationApi::class)
@SerialName("message")
@Serializable
data class MessageEvent(
    @Serializable(MillisToLocalDateTimeSerializer::class)
    val time: LocalDateTime,

    @SerialName("post_type")
    @Serializable(EventPostTypeSerializer::class)
    val postType: EventPostType,

    @SerialName("user_id")
    val userId: Long,

    val message: List<Message>
) : Event



@OptIn(ExperimentalSerializationApi::class)
@SerialName("meta_event")
@Serializable
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
class NoticeEvent(
    @Serializable(MillisToLocalDateTimeSerializer::class)
    val time: LocalDateTime,

    @SerialName("post_type")
    @Serializable(EventPostTypeSerializer::class)
    val postType: EventPostType
) : Event
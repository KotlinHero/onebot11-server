package tech.kotlinhero.onebot11.post

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import tech.kotlinhero.onebot11.post.message.MessageSegmentType
import tech.kotlinhero.onebot11.post.message.MessageSegmentTypeSerializer

@Serializable
sealed interface Message

@SerialName("text")
@Serializable
class TextMessage(
    @Serializable(with = MessageSegmentTypeSerializer::class)
    val type: MessageSegmentType,
    val data: Data,
) : Message {
    @Serializable
    data class Data(
        val text: String
    )
}

@SerialName("image")
@Serializable
class ImageMessage(
    @Serializable(with = MessageSegmentTypeSerializer::class)
    val type: MessageSegmentType,
) : Message

@SerialName("reply")
@Serializable
class ReplyMessage(
    @Serializable(with = MessageSegmentTypeSerializer::class)
    val type: MessageSegmentType,
) : Message

@SerialName("at")
@Serializable
class AtMessage(
    @Serializable(with = MessageSegmentTypeSerializer::class)
    val type: MessageSegmentType,
) : Message

@SerialName("face")
@Serializable
class FaceMessage(
    @Serializable(with = MessageSegmentTypeSerializer::class)
    val type: MessageSegmentType,
    val data: Data,
) : Message {
    @Serializable
    data class Data(
        val id: String,

        @SerialName("sub_type")
        val subType: Int
    )
}
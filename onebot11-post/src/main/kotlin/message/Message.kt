package tech.kotlinhero.onebot11.post.message

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonIgnoreUnknownKeys

@Serializable
sealed interface Message

@SerialName("text")
@Serializable
data class TextMessage(
    @Serializable(with = MessageSegmentTypeSerializer::class)
    val type: MessageSegmentType,
    val data: Data,
) : Message {
    @Serializable
    data class Data(
        val text: String
    )
}

@SerialName("at")
@Serializable
data class AtMessage(
    @Serializable(with = MessageSegmentTypeSerializer::class)
    val type: MessageSegmentType,
    val data: Data,
) : Message {
    @Serializable
    data class Data(
        val qq: String,
        val name: String
    )
}

@SerialName("face")
@Serializable
data class FaceMessage(
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


@SerialName("image")
@Serializable
data class ImageMessage(
    @Serializable(with = MessageSegmentTypeSerializer::class)
    val type: MessageSegmentType,
    val data: Data,
) : Message {
    @Serializable
    data class Data(
        val file: String,
        val subType: Long,
        val url: String,
        @SerialName("file_size")
        val fileSize: Long,
        //1D87943D9987A3BFFF026CA66D6A7548.jpg
        //411F9042A8772A7BB6B062003250096B.jpg
    )
}

@OptIn(ExperimentalSerializationApi::class)
@SerialName("reply")
@Serializable
@JsonIgnoreUnknownKeys
data class ReplyMessage(
    @Serializable(with = MessageSegmentTypeSerializer::class)
    val type: MessageSegmentType,
) : Message

@OptIn(ExperimentalSerializationApi::class)
@SerialName("json")
@Serializable
@JsonIgnoreUnknownKeys
data class JsonMessage(
    @Serializable(with = MessageSegmentTypeSerializer::class)
    val type: MessageSegmentType,
) : Message

@OptIn(ExperimentalSerializationApi::class)
@SerialName("forward")
@Serializable
@JsonIgnoreUnknownKeys
data class ForwardMessage(
    @Serializable(with = MessageSegmentTypeSerializer::class)
    val type: MessageSegmentType,
) : Message
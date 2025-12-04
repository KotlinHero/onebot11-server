package tech.kotlinhero.onebot11.post.serialization

import kotlinx.serialization.KSerializer
import tech.kotlinhero.onebot11.post.MessageType

class MessageTypeSerializer : KSerializer<MessageType> by StringToEnumSerializer(
    { MessageType.valueOf(it) }
)
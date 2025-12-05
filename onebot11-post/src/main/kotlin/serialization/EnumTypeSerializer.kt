package tech.kotlinhero.onebot11.post.serialization

import kotlinx.serialization.KSerializer
import tech.kotlinhero.onebot11.post.EventPostType
import tech.kotlinhero.onebot11.post.MessageType


class EventPostTypeSerializer : KSerializer<EventPostType> by StringToEnumSerializer(
    { EventPostType.valueOf(it) }
)

class MessageTypeSerializer : KSerializer<MessageType> by StringToEnumSerializer(
    { MessageType.valueOf(it) }
)


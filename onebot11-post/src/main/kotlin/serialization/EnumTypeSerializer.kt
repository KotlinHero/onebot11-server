package tech.kotlinhero.onebot11.post.serialization

import kotlinx.serialization.KSerializer
import tech.kotlinhero.onebot11.post.event.EventPostType
import tech.kotlinhero.onebot11.post.message.MessageType


class EventPostTypeSerializer : KSerializer<EventPostType> by StringToEnumSerializer(
    { EventPostType.valueOf(it) }
)

class MessageTypeSerializer : KSerializer<MessageType> by StringToEnumSerializer(
    { MessageType.valueOf(it) }
)


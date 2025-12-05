package tech.kotlinhero.onebot11.post.message

import kotlinx.serialization.KSerializer
import tech.kotlinhero.onebot11.post.serialization.StringToEnumSerializer

class MessageSegmentTypeSerializer : KSerializer<MessageSegmentType> by StringToEnumSerializer(
    { MessageSegmentType.valueOf(it) }
)
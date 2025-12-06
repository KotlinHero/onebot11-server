package tech.kotlinhero.onebot11.post.message

import kotlinx.serialization.KSerializer
import tech.kotlinhero.onebot11.post.serialization.StringToEnumSerializer

class MessageSubTypeSerializer : KSerializer<MessageSubType> by StringToEnumSerializer(
    { MessageSubType.valueOf(it) }
)
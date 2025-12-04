package tech.kotlinhero.onebot11.post.serialization

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class StringToEnumSerializer<T>(
    private val deserializer: (String) -> T
) : KSerializer<T> where T : Enum<T> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("MessageType", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: T) {
        encoder.encodeString(value.name.lowercase())
    }

    override fun deserialize(decoder: Decoder): T {
        return deserializer(decoder.decodeString().uppercase())
    }
}
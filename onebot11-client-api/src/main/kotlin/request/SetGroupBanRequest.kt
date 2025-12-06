package tech.kotlinhero.onebot11.client.api.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

fun setGroupBanRequest(
    groupId: Long,
    userId: Long,
    duration: Long
) = SetGroupBanRequest(
    action = "set_group_ban",
    params = SetGroupBanRequest.Params(
        groupId = groupId,
        userId = userId,
        duration = duration
    )
)

@Serializable
data class SetGroupBanRequest(
    val action: String,
    val params: Params
) : OneBot11Request {
    @Serializable
    data class Params(
        @SerialName("group_id")
        val groupId: Long,

        @SerialName("user_id")
        val userId: Long,

        val duration: Long
    )
}


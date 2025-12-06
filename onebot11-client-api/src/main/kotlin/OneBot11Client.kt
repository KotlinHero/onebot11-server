package tech.kotlinhero.onebot11.client.api

interface OneBot11Client {
    /**
     * 禁言群成员
     * @param groupId 群号
     * @param userId 成员QQ号
     * @param duration 禁言时长，单位秒，0为取消禁言
     */
    suspend fun setGroupBan(groupId: Long, userId: Long, duration: Long)
}
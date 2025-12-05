package tech.kotlinhero.onebot11.server

typealias UserId = Long
typealias Message = String

class GroupMessageRepeatMuter {
    private val oneMinuteMessages = mutableMapOf<UserId, List<Message>>()

    private fun receiveMessage(userId: UserId, message: Message) {
        val repeatCount = message.let {
            val existCount = oneMinuteMessages[userId]
                ?.filter { existMessage -> existMessage == message }
                ?.size
                ?: 0
            if (it.isBasketBallMessage()) {
                existCount + 3
            } else {
                existCount + 1
            }
        }
        if (repeatCount >= 5) {
            muteUser(userId, 1)
        }
    }

    private fun Message.isBasketBallMessage() = this.contains("篮球")

    private fun muteUser(userId: UserId, muteMinutes: Long) {

    }

}
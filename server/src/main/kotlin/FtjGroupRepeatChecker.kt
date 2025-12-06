package tech.kotlinhero.onebot11.server

import io.ktor.util.collections.*
import kotlinx.coroutines.*
import tech.kotlinhero.onebot11.post.event.MessageEvent
import tech.kotlinhero.onebot11.post.message.FaceMessage
import tech.kotlinhero.onebot11.post.message.ImageMessage
import tech.kotlinhero.onebot11.post.message.Message
import tech.kotlinhero.onebot11.post.message.TextMessage
import kotlin.time.Duration.Companion.minutes


fun CoroutineScope.ftjGroupRepeatChecker(
    interval: Long = 1.minutes.inWholeMilliseconds,
    targetGroups: List<Long>
): FtjGroupRepeatChecker =
    FtjGroupRepeatChecker(this, interval, targetGroups)

class FtjGroupRepeatChecker(
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Default),
    private val interval: Long,
    val targetGroups: List<Long>
) : CoroutineScope by scope {

    private val userMessages: ConcurrentMap<Long, MutableList<Message>> = ConcurrentMap()

    init {
        startCleanupJob()
    }

    private fun startCleanupJob() {
        launch {
            while (isActive) {
                delay(interval)
                userMessages.clear()
                println("user messages is clear")
            }
        }
    }

    private fun addMessage(userId: Long, message: Message) {
        val messages = userMessages.getOrPut(userId) { mutableListOf() }
        messages.add(message)
    }

    suspend fun checkRepeat(event: MessageEvent, action: suspend () -> Unit) {
        if (!targetGroups.contains(event.groupId)) {
            return
        }
        val userId = event.userId
        event.message.forEach { message ->
            addMessage(userId, message)
            val repeatCount = when (message) {
                is TextMessage -> {
                    println(message.toString())
                    val existCount = userMessages[userId]?.filter {
                        it is TextMessage
                    }?.filter {
                        (it as TextMessage).data.text == message.data.text
                    }?.size ?: 0
                    existCount
                }

                is ImageMessage -> {
                    println(message.toString())
                    val existCount = userMessages[userId]?.filter {
                        it is ImageMessage
                    }?.filter {
                        (it as ImageMessage).data.file == message.data.file
                    }?.size ?: 0
                    existCount + 1
                }

                is FaceMessage -> {
                    println(message.toString())
                    val existCount = userMessages[userId]?.filter {
                        it is FaceMessage
                    }?.filter {
                        val data = (it as FaceMessage).data
                        data.subType == message.data.subType
                                && data.id == message.data.id
                    }?.size ?: 0
                    existCount + 1
                }

                else -> 0
            }
            println(repeatCount)
            if (repeatCount >= 4) {
                action()
            }
        }
    }
}
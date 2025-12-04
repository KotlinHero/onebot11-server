package tech.kotlinhero.onebot11.post.event

import tech.kotlinhero.onebot11.post.EventPostType
import java.time.LocalDateTime

interface PostEventMetadata {
    val selfId: String
    val time: LocalDateTime
    val postType: EventPostType
}
package tech.kotlinhero.onebot11.post.serialization

import kotlinx.serialization.json.Json
import tech.kotlinhero.onebot11.post.event.Event

fun String.deserializeToEvent(): Event = Json.decodeFromString(this)
package tech.kotlinhero.onebot11.client.api.request

import kotlinx.serialization.json.Json

inline fun <reified T : OneBot11Request> T.encodeToString() = Json.encodeToString(this)
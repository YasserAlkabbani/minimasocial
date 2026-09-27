package com.yasser.minimasocial.core.data.extentions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend inline fun <T, R> T.mapObject(
    crossinline mapTo: suspend T.() -> R
): R = withContext(Dispatchers.Default) {
    mapTo()
}

suspend inline fun <T> T.withObject(
    crossinline block: suspend T.() -> Unit
): T = withContext(Dispatchers.Default) {
    block()
    this@withObject
}
package com.yasser.minimasocial.core.data.extentions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

inline fun <T, R> Flow<T>.mapFlow(
    crossinline mapTo: suspend T.() -> R
): Flow<R> = map {
    it.mapTo()
}.flowOn(Dispatchers.Default)
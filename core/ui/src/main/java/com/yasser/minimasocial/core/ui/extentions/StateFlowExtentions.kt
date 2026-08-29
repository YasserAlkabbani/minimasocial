package com.yasser.minimasocial.core.ui.extentions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

fun <T> Flow<T>.asStateFlow(
    initValue: T,
    scope: CoroutineScope
): StateFlow<T> = stateIn(
    scope = scope,
    initialValue = initValue,
    started = SharingStarted.WhileSubscribed(5000)
)


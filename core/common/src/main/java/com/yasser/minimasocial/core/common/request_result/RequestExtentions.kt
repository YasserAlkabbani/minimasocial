package com.yasser.minimasocial.core.common.request_result

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import java.net.SocketTimeoutException
import java.net.UnknownHostException


fun <T> requestWithState(request: suspend () -> T): Flow<RequestState<T>> =
    flow<RequestState<T>> { RequestState.Success(request()) }
        .onStart { emit(RequestState.Loading) }
        .catch { emit(RequestState.Error(it.asRequestError())) }
        .flowOn(Dispatchers.Default)


fun <T> Flow<T>.asStateFlow(
    initValue: T,
    scope: CoroutineScope
): StateFlow<T> = stateIn(
    scope = scope,
    initialValue = initValue,
    started = SharingStarted.WhileSubscribed(5000)
)


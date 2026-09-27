package com.yasser.minimasocial.core.data.extentions

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.common.request_result.handleError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend inline fun <T, R> RequestResult<T>.mapSuccessResult(
    crossinline mapTo: suspend T.() -> R
): RequestResult<R> = when (this) {
    is RequestResult.Success<T> -> try {
        withContext(Dispatchers.Default) {
            val mappedData = data.mapTo()
            RequestResult.Success(mappedData)
        }
    } catch (throwable: Throwable) {
        throwable.handleError()
    }

    is RequestResult.Error -> this
}

suspend inline fun <T> RequestResult<T>.withSuccessResult(
    block: suspend T.() -> Unit
): RequestResult<T> = when (this) {
    is RequestResult.Success<T> -> {
        block(data)
        this
    }

    is RequestResult.Error -> this
}
package com.yasser.minimasocial.core.data


import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.common.request_result.handleError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


suspend inline fun <T, R> RequestResult<T>.mapTo(crossinline map: suspend T.() -> R): RequestResult<R> =
    when (this) {
        is RequestResult.Success<T> -> try {
            withContext(Dispatchers.Default) {
                val mappedData = data.map()
                RequestResult.Success(mappedData)
            }
        } catch (throwable: Throwable) {
            throwable.handleError()
        }

        is RequestResult.Error -> this
    }
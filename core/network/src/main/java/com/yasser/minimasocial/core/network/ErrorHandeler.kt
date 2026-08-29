package com.yasser.minimasocial.core.network

import com.yasser.minimasocial.core.common.request_result.RequestError
import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.common.request_result.asRequestResult
import com.yasser.minimasocial.core.common.request_result.handleError
import retrofit2.HttpException

private fun Throwable.handleHttpRequestError(): RequestResult.Error = when (this) {
    is HttpException -> when (this.code()) {
        400 -> RequestError.HttpBadRequest
        401 -> RequestError.HttpUnauthenticated
        403 -> RequestError.HttpForbidden
        404 -> RequestError.HttpNotFound
        in 500..599 -> RequestError.HttpServerError
        else -> {
            val errorBody = response()?.errorBody()?.string().orEmpty()
            RequestError.HttpUnknownError(
                errorCode = code(),
                errorMessage = errorBody
            )
        }
    }.asRequestResult()

    else -> handleError()
}

internal suspend fun <T> requestWithResult(
    request: suspend () -> T
): RequestResult<T> = try {
    val requestResult = request()
    RequestResult.Success(requestResult)
} catch (throwable: Throwable) {
    throwable.handleHttpRequestError()
}
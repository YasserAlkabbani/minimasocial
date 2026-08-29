package com.yasser.minimasocial.core.common.request_result

import kotlinx.serialization.SerializationException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlin.coroutines.cancellation.CancellationException

sealed interface RequestError {
    data object InvalidCertification : RequestError
    data object InvalidInput : RequestError
    data object InvalidEmail : RequestError
    data object InvalidPassword : RequestError
    data object SerializationError : RequestError
    data object NullError : RequestError
    data class UnknownError(val errorMessage: String) : RequestError

    data object ConnectionTimeout : RequestError
    data object NoInternetConnection : RequestError

    data object HttpBadRequest : RequestError      // 400
    data object HttpUnauthenticated : RequestError // 401
    data object HttpForbidden : RequestError       // 403
    data object HttpNotFound : RequestError        // 404
    data object HttpServerError : RequestError     // 500
    data class HttpUnknownError(val errorCode: Int, val errorMessage: String) : RequestError
}

fun RequestError.asRequestResult() = RequestResult.Error(this)

fun Throwable.handleError(): RequestResult.Error = when (this) {
    is CancellationException -> throw this
    is SocketTimeoutException -> RequestError.ConnectionTimeout
    is UnknownHostException, is ConnectException, is IOException -> RequestError.NoInternetConnection
    is SerializationException -> RequestError.SerializationError
    is NullPointerException -> RequestError.NullError
    else -> RequestError.UnknownError(errorMessage = message ?: "UNKNOWN ERROR")
}.asRequestResult()
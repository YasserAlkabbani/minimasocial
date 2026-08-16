package com.yasser.minimasocial.core.common.request_result

import java.net.SocketTimeoutException
import java.net.UnknownHostException

enum class RequestError {
    NO_INTERNET_CONNECTION,
    CONNECTION_TIMEOUT,
    UNKNOWN_ERROR
}

fun Throwable.asRequestError(): RequestError = when (this) {
    is UnknownHostException -> RequestError.NO_INTERNET_CONNECTION
    is SocketTimeoutException -> RequestError.CONNECTION_TIMEOUT
    else -> RequestError.UNKNOWN_ERROR
}
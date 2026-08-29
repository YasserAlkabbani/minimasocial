package com.yasser.minimasocial.core.common.request_result


sealed interface RequestResult<out T> {

    data class Success<T>(val data: T) : RequestResult<T>

    data class Error(val requestError: RequestError) : RequestResult<Nothing>

}

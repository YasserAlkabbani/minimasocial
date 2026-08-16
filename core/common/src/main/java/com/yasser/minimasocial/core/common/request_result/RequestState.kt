package com.yasser.minimasocial.core.common.request_result


sealed interface RequestState<out T> {

    data object Loading : RequestState<Nothing>

    data class Success<T>(val data: T) : RequestState<T>

    data class Error(val requestError: RequestError) : RequestState<Nothing>

}
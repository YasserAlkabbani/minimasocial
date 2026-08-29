package com.yasser.minimasocial.feature.auth.register.impl.ui

import com.yasser.minimasocial.core.common.request_result.RequestError
import com.yasser.minimasocial.core.common.request_result.RequestResult

sealed interface RegisterUIState {

    data object Idle : RegisterUIState
    data object Loading : RegisterUIState
    data object Success : RegisterUIState
    data class Error(val requestError: RequestError) : RegisterUIState

}

sealed interface RegisterNavigation {
    data object Idle : RegisterNavigation
    data object NavigateBack : RegisterNavigation
}
package com.yasser.minimasocial.feature.auth.login.impl.ui

import com.yasser.minimasocial.core.common.request_result.RequestError

sealed interface LoginUIState {
    data object Idle : LoginUIState
    data object Loading : LoginUIState
    data object Success : LoginUIState
    data class Error(val requestError: RequestError) : LoginUIState
}

sealed interface LoginNavigation {
    data object Idle : LoginNavigation
    data object Register : LoginNavigation
}
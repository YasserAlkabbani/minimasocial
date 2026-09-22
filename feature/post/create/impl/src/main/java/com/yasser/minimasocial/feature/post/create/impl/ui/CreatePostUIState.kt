package com.yasser.minimasocial.feature.post.create.impl.ui

import com.yasser.minimasocial.core.common.request_result.RequestError

sealed interface CreatePostUIState {
    data object Idle : CreatePostUIState
    data object Loading : CreatePostUIState
    data object Success : CreatePostUIState
    data class Error(val requestError: RequestError) : CreatePostUIState
}

sealed interface CreatePostNavigation {
    data object Idle : CreatePostNavigation
    data object NavigateBack : CreatePostNavigation
}
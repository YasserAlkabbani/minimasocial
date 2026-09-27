package com.yasser.minimasocial.feature.home.impl.ui

import com.yasser.minimasocial.core.model.post.Post

sealed interface HomeUIState


sealed interface HomeNavigation {
    data object Idle : HomeNavigation
    data class PostDetails(val post: Post) : HomeNavigation
}
package com.yasser.minimasocial.feature.post.details.impl.navigation

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import com.yasser.minimasocial.feature.post.details.api.ViewPostNavKey
import com.yasser.minimasocial.feature.post.details.impl.ui.PostDetailsScreen
import com.yasser.minimasocial.feature.post.details.impl.ui.ViewPostViewModel

fun EntryProviderScope<NavKey>.viewPostEntity(navigator: Navigator) {
    entry<ViewPostNavKey> { key ->
        val postID = key.postID
        PostDetailsScreen(
            viewPostViewModel = hiltViewModel<ViewPostViewModel, ViewPostViewModel.Factory> { factory ->
                factory.create(postID = postID)
            }
        )
    }

}
package com.yasser.minimasocial.feature.post.create.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import com.yasser.minimasocial.feature.post.create.api.CreatePostNavKey

fun EntryProviderScope<NavKey>.createPostEntity(navigator: Navigator){
    entry<CreatePostNavKey> {

    }
}
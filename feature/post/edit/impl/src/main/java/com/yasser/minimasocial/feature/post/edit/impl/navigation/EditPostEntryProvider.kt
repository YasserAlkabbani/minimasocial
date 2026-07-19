package com.yasser.minimasocial.feature.post.edit.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import com.yasser.minimasocial.feature.post.edit.api.EditPostNavKey
import com.yasser.minimasocial.feature.post.edit.impl.ui.EditPostScreen

fun EntryProviderScope<NavKey>.editPostEntity(navigator: Navigator){
    entry<EditPostNavKey> {
        EditPostScreen()
    }
}
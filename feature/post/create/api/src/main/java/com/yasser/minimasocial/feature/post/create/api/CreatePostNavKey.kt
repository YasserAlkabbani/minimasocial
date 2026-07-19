package com.yasser.minimasocial.feature.post.create.api

import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
data object CreatePostNavKey: NavKey

fun Navigator.navigateToCreatePost(){
    navigate(CreatePostNavKey)
}
package com.yasser.minimasocial.feature.post.details.api

import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
data class ViewPostNavKey(val postID: String) : NavKey


fun Navigator.navigateToPostDetails(postID: String) {
    navigate(ViewPostNavKey(postID = postID))
}
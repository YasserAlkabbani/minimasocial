package com.yasser.minimasocial.feature.post.view.api

import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
data object ViewPostNavKey: NavKey


fun Navigator.navigateToViewPost(){
    navigate(ViewPostNavKey)
}
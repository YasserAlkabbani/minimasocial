package com.yasser.minimasocial.feature.home.api

import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
data object HomeNavKey: NavKey

fun Navigator.navigateToHome(){
    navigate(HomeNavKey)
}
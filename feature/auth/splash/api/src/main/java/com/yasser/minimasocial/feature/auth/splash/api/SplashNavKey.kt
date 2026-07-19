package com.yasser.minimasocial.feature.auth.splash.api

import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
data object SplashNavKey: NavKey

fun Navigator.navigateToSplash(){
    navigate(SplashNavKey,true)
}
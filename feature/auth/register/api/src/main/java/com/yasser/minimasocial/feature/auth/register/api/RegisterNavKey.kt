package com.yasser.minimasocial.feature.auth.register.api

import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
object RegisterNavKey: NavKey

fun Navigator.navigateToRegister(){
    navigate(RegisterNavKey)
}
package com.yasser.minimasocial.feature.profile.api

import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
data object ProfileNavKey: NavKey

fun Navigator.navigateToProfile(){
    navigate(ProfileNavKey)
}
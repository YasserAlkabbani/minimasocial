package com.yasser.minimasocial.feature.search.api

import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import kotlinx.serialization.Serializable

@Serializable
data object SearchNavKey: NavKey

fun Navigator.navigateToSearch(){
    navigate(SearchNavKey)
}
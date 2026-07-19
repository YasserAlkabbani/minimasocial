package com.yasser.minimasocial.feature.home.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import com.yasser.minimasocial.feature.home.api.HomeNavKey
import com.yasser.minimasocial.feature.home.impl.ui.HomeScreen

fun EntryProviderScope<NavKey>.homeEntry(navigator: Navigator) {
    entry<HomeNavKey> {
        HomeScreen()
    }

}
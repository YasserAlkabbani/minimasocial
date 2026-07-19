package com.yasser.minimasocial.core.navigation

import androidx.navigation3.runtime.NavKey

class Navigator(private val navigationState: NavigationState) {

    fun navigate(navKey: NavKey, clearPrevious: Boolean = false) {
        if (clearPrevious || navKey == navigationState.topLevelStack.first()) navigationState.navBackStack.clear()
        navigationState.navBackStack.remove(navKey)
        navigationState.navBackStack.add(navKey)
    }


    fun goBack() =
        navigationState.navBackStack.removeLastOrNull()

    fun removeAllScreens(): Unit =
        navigationState.navBackStack.clear()

}
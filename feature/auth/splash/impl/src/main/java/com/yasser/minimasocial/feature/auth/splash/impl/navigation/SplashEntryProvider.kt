package com.yasser.minimasocial.feature.auth.splash.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import com.yasser.minimasocial.feature.auth.login.api.navigateToLogin
import com.yasser.minimasocial.feature.auth.splash.api.SplashNavKey
import com.yasser.minimasocial.feature.auth.splash.api.navigateToSplash
import com.yasser.minimasocial.feature.auth.splash.impl.ui.SplashScreen

fun EntryProviderScope<NavKey>.splashEntry(navigator: Navigator) {
    entry<SplashNavKey>{
        SplashScreen(
            navigateToLogin = navigator::navigateToLogin
        )
    }
}
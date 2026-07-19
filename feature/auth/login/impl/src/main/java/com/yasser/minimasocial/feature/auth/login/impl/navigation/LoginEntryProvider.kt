package com.yasser.minimasocial.feature.auth.login.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import com.yasser.minimasocial.feature.auth.login.api.LoginNavKey
import com.yasser.minimasocial.feature.auth.login.impl.ui.LoginScreen
import com.yasser.minimasocial.feature.auth.register.api.navigateToRegister

fun EntryProviderScope<NavKey>.loginEntry(navigator: Navigator) {
    entry<LoginNavKey> {
        LoginScreen(
            navigateToRegister = navigator::navigateToRegister
        )
    }
}
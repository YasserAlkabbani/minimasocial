package com.yasser.minimasocial.feature.auth.register.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import com.yasser.minimasocial.feature.auth.register.api.RegisterNavKey
import com.yasser.minimasocial.feature.auth.register.impl.ui.RegisterScreen


fun EntryProviderScope<NavKey>.registerEntry(navigator: Navigator) {
    entry<RegisterNavKey> {
        RegisterScreen(
            navigateBack = navigator::goBack
        )
    }
}
package com.yasser.minimasocial.feature.profile.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import com.yasser.minimasocial.feature.profile.api.ProfileNavKey
import com.yasser.minimasocial.feature.profile.impl.ui.ProfileScreen

fun EntryProviderScope<NavKey>.profileEntry(navigator: Navigator){
    entry<ProfileNavKey> {
        ProfileScreen()
    }
}
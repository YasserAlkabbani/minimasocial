package com.yasser.minimasocial.feature.search.impl.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import com.yasser.minimasocial.feature.search.api.SearchNavKey
import com.yasser.minimasocial.feature.search.impl.ui.SearchScreen

fun EntryProviderScope<NavKey>.searchEntry(navigator: Navigator){
    entry<SearchNavKey> {
        SearchScreen()
    }
}
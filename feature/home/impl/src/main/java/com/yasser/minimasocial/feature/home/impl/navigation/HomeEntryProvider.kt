package com.yasser.minimasocial.feature.home.impl.navigation

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.yasser.minimasocial.core.navigation.Navigator
import com.yasser.minimasocial.feature.home.api.HomeNavKey
import com.yasser.minimasocial.feature.home.impl.ui.HomeScreen
import com.yasser.minimasocial.feature.post.details.api.navigateToPostDetails

fun EntryProviderScope<NavKey>.homeEntry(navigator: Navigator) {
    entry<HomeNavKey> {
        HomeScreen(
            homeViewModel = hiltViewModel(),
            navigateToPostDetails = navigator::navigateToPostDetails
        )
    }

}
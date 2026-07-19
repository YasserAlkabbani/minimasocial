package com.yasser.minimasocial.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.yasser.minimasocial.core.navigation.Navigator
import com.yasser.minimasocial.core.navigation.rememberNavigationState
import com.yasser.minimasocial.core.navigation.toEntries
import com.yasser.minimasocial.feature.auth.splash.impl.navigation.splashEntry
import com.yasser.minimasocial.feature.auth.splash.api.SplashNavKey
import com.yasser.minimasocial.core.designsystem.theme.MinimaSocialTheme
import com.yasser.minimasocial.core.ui.MSFloatingNavigationBar
import com.yasser.minimasocial.core.ui.MSFloatingNavigationBarItem
import com.yasser.minimasocial.feature.auth.login.impl.navigation.loginEntry
import com.yasser.minimasocial.feature.auth.register.impl.navigation.registerEntry
import com.yasser.minimasocial.feature.home.impl.navigation.homeEntry
import com.yasser.minimasocial.feature.post.create.impl.navigation.createPostEntity
import com.yasser.minimasocial.feature.post.edit.impl.navigation.editPostEntity
import com.yasser.minimasocial.feature.post.view.impl.navigation.viewPostEntity
import com.yasser.minimasocial.feature.profile.impl.navigation.profileEntry
import com.yasser.minimasocial.feature.search.impl.navigation.searchEntry
import com.yasser.minimasocial.navigation.TOP_LEVEL_NAV_ITEMS


@Composable
fun MSApp() {
    val navigationState = rememberNavigationState(
        startKey = SplashNavKey,
        topLevelStack = TOP_LEVEL_NAV_ITEMS.keys
    )
    val navigator = remember(navigationState) { Navigator(navigationState) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (navigationState.isMainDestination)
                MSFloatingNavigationBar(
                    content = {
                        TOP_LEVEL_NAV_ITEMS.forEach { (navKey, navItem) ->
                            val selected = navKey == navigationState.currentBackStack
                            MSFloatingNavigationBarItem(
                                icon = navItem.icon,
                                selectedIcon = navItem.selectedIcon,
                                selected = selected,
                                onClick = { navigator.navigate(navKey) }
                            )
                        }
                    }
                )
        },
        content = { innerPadding ->

            val entryProvider: (NavKey) -> NavEntry<NavKey> = entryProvider {
                splashEntry(navigator)
                loginEntry(navigator)
                registerEntry(navigator)
                homeEntry(navigator)
                searchEntry(navigator)
                profileEntry(navigator)
                createPostEntity(navigator)
                viewPostEntity(navigator)
                editPostEntity(navigator)
            }

            NavDisplay(
                modifier = Modifier.padding(innerPadding),
                entries = navigationState.toEntries(entryProvider),
                onBack = navigator::goBack
            )

        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MinimaSocialTheme {

    }
}


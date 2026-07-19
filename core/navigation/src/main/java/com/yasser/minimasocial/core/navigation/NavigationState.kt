package com.yasser.minimasocial.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberDecoratedNavEntries
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator

@Composable
fun rememberNavigationState(
    startKey: NavKey,
    topLevelStack: Set<NavKey>,
): NavigationState {

    val navBackStack: NavBackStack<NavKey> = rememberNavBackStack(startKey)

    return remember(startKey) {
        NavigationState(
            startKey = startKey,
            topLevelStack = topLevelStack,
            navBackStack = navBackStack,
        )
    }

}


class NavigationState(
    val startKey: NavKey,
    val topLevelStack: Set<NavKey>,
    val navBackStack: NavBackStack<NavKey>
) {
    val currentBackStack: NavKey by derivedStateOf { navBackStack.last() }
    val isMainDestination: Boolean by derivedStateOf { currentBackStack in topLevelStack }
}

@Composable
fun NavigationState.toEntries(
    entryProvider: (NavKey) -> NavEntry<NavKey>
): SnapshotStateList<NavEntry<NavKey>> {

    val decorators: List<NavEntryDecorator<NavKey>> = listOf(
        rememberSaveableStateHolderNavEntryDecorator(),
        rememberViewModelStoreNavEntryDecorator()
    )

    return rememberDecoratedNavEntries(
        backStack = navBackStack,
        entryProvider = entryProvider,
        entryDecorators = decorators
    ).toMutableStateList()

}
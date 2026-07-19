package com.yasser.minimasocial.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.yasser.minimasocial.R
import com.yasser.minimasocial.core.designsystem.icon.MSIcon
import com.yasser.minimasocial.feature.home.api.HomeNavKey
import com.yasser.minimasocial.feature.profile.api.ProfileNavKey
import com.yasser.minimasocial.feature.search.api.SearchNavKey

data class TopLevelNavItem(
    val selectedIcon: ImageVector,
    val icon: ImageVector,
    val iconTextID: Int
)

val HOME = TopLevelNavItem(
    selectedIcon = MSIcon.HOME,
    icon = MSIcon.HOME_SELECTED,
    iconTextID = R.string.home
)
val SEARCH = TopLevelNavItem(
    selectedIcon = MSIcon.SEARCH,
    icon = MSIcon.SEARCH_SELECTED,
    iconTextID = R.string.search
)
val PROFILE = TopLevelNavItem(
    selectedIcon = MSIcon.PROFILE,
    icon = MSIcon.PROFILE_SELECTED,
    iconTextID = R.string.profile
)

val TOP_LEVEL_NAV_ITEMS = mapOf(
    HomeNavKey to HOME,
    SearchNavKey to SEARCH,
    ProfileNavKey to PROFILE
)
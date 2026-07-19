package com.yasser.minimasocial.core.ui

import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.yasser.minimasocial.core.designsystem.icon.MSIcon

@Composable
fun MSFloatingNavigationBarItem(
    icon: ImageVector,
    selectedIcon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit,
) {
    FilledTonalIconToggleButton(
        modifier = Modifier,
        checked = selected,
        content = {
            Icon(
                imageVector = if (selected) selectedIcon else icon,
                contentDescription = null
            )
        },
        onCheckedChange = { onClick() },

        )
}

@Preview
@Composable
private fun MSFloatingNavigationBarItemPreview() {
    MSFloatingNavigationBarItem(
        icon = MSIcon.HOME,
        selectedIcon = MSIcon.HOME_SELECTED,
        selected = false,
        onClick = {}
    )
}

@Preview
@Composable
private fun MSFloatingNavigationBarItemSelectedPreview() {
    MSFloatingNavigationBarItem(
        icon = MSIcon.HOME,
        selectedIcon = MSIcon.HOME_SELECTED,
        selected = true,
        onClick = {}
    )
}
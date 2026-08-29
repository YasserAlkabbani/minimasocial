package com.yasser.minimasocial.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingToolbarDefaults
import androidx.compose.material3.HorizontalFloatingToolbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yasser.minimasocial.core.designsystem.icon.MSIcons

@Composable
fun MSFloatingNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        HorizontalFloatingToolbar(
            modifier = modifier,
            expanded = false,
            shape = FloatingToolbarDefaults.ContainerShape,
            colors = FloatingToolbarDefaults.vibrantFloatingToolbarColors(),
            content = content,
            leadingContent = {},
            trailingContent = {},
        )
    }


}

@Preview
@Composable
private fun MSFloatingNavigationBarPreview() {
    MSFloatingNavigationBar(
        content = {
            MSFloatingNavigationBarItem(
                icon = MSIcons.HOME,
                selectedIcon = MSIcons.HOME_SELECTED,
                selected = false,
                onClick = {}
            )
            MSFloatingNavigationBarItem(
                icon = MSIcons.SEARCH,
                selectedIcon = MSIcons.SEARCH_SELECTED,
                selected = true,
                onClick = {}
            )
            MSFloatingNavigationBarItem(
                icon = MSIcons.PROFILE,
                selectedIcon = MSIcons.PROFILE_SELECTED,
                selected = false,
                onClick = {}
            )
        }
    )
}
package com.yasser.minimasocial.core.designsystem.component

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.yasser.minimasocial.core.designsystem.icon.MSIcon

@Composable
fun MSIcon(imageVector: ImageVector) {
    Icon(
        imageVector = imageVector,
        contentDescription = null
    )
}


@Preview
@Composable
private fun MSIconPreview() {
    MSIcon(
        MSIcon.MINIMA_SOCIAL
    )
}
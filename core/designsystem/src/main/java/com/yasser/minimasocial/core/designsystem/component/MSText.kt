package com.yasser.minimasocial.core.designsystem.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MSText(
    text: String
) {
    Text(text)
}


@Preview
@Composable
private fun MSTextPreview() {
    MSText(
        "TEST TEXT FOR PREVIEW"
    )
}
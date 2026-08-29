@file:OptIn(ExperimentalFoundationStyleApi::class)

package com.yasser.minimasocial.core.designsystem.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.style.ExperimentalFoundationStyleApi
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.StyleStateKey
import androidx.compose.foundation.style.fillWidth
import androidx.compose.foundation.style.rememberUpdatedStyleState
import androidx.compose.foundation.style.styleable
import androidx.compose.foundation.style.then
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MSTextField(
    textFieldState: TextFieldState,
    style: Style = Style()
) {
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    val styleStateKey: StyleStateKey<Boolean> = StyleStateKey(true)
    val styleState = rememberUpdatedStyleState(interactionSource) { state ->
        state[styleStateKey] = true
    }
    val textFieldStyle = Style {
        fillWidth()
    }.then(style)

    TextField(
        modifier = Modifier.styleable(styleState, textFieldStyle),
        state = textFieldState,
    )

}


@Preview
@Composable
fun MSTextFieldPreview() {

}
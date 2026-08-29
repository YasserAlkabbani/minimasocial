package com.yasser.minimasocial.core.ui.extentions

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewmodel.compose.saveable

fun SavedStateHandle.asSavableTextFieldState(key: String) = saveable(
    key = key,
    saver = TextFieldState.Saver,
    init = { TextFieldState() }
)
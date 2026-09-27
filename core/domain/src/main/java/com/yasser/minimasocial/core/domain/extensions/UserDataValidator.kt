package com.yasser.minimasocial.core.domain.extensions

import androidx.core.util.PatternsCompat

internal fun String.isValidEmail() =
    PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()

internal fun String.isValidPassword() =
    isNotBlank() && length >= 8 && any { it.isDigit() } && any { it.isUpperCase() }

internal fun String.isValidPostTitle() =
    isNotBlank()

internal fun String.isValidPostContent() =
    isNotBlank()
package com.yasser.minimasocial.core.domain.auth.extensions

import androidx.core.util.PatternsCompat

fun String.isValidEmail() =
    PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidPassword() =
    isNotBlank() && length >= 8 && any { it.isDigit() } && any { it.isUpperCase() }

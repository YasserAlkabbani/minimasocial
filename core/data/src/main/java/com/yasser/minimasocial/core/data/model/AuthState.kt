package com.yasser.minimasocial.core.data.model

import com.yasser.minimasocial.core.model.auth.AuthState

fun Boolean.asAuthState(): AuthState = when (this) {
    true -> AuthState.AUTHENTICATED
    false -> AuthState.UNAUTHENTICATED
}
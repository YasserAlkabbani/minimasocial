package com.yasser.minimasocial.core.model

data class RefreshToken(
    val accessToken: String,
    val refreshToken: String
)
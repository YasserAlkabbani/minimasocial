package com.yasser.minimasocial.core.model

data class Login(
    val user: MSUser,
    val accessToken: String,
    val refreshToken: String
)
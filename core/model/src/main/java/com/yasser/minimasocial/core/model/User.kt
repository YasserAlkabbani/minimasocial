package com.yasser.minimasocial.core.model

data class MSUser(
    val id: String,
    val email: String,
    val phone: String,
    val emailVerified: Boolean,
)
package com.yasser.minimasocial.core.model.user

data class MSUser(
    val id: String,
    val email: String,
    val phone: String,
    val emailVerified: Boolean,
    val currentUser: Boolean
)
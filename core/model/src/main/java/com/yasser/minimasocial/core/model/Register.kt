package com.yasser.minimasocial.core.model

data class Register(
    val id: String,
    val email: String,
    val phone: String,
    val createdAt: String,
    val updatedAt: String,
    val emailVerified: Boolean,
    val phoneVerified: Boolean,
)
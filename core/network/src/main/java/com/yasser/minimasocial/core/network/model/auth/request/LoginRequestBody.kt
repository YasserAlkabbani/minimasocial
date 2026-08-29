package com.yasser.minimasocial.core.network.model.auth.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestBody(
    @SerialName("email") val email: String,
    @SerialName("password") val password: String,
)
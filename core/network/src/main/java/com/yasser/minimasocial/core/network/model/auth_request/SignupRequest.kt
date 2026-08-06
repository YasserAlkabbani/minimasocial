package com.yasser.minimasocial.core.network.model.auth_request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SignupRequest(
    @SerialName("email") val email: String,
    @SerialName("password") val password: String,
)
package com.yasser.minimasocial.core.network.model.auth_request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignupResponse(
    @SerialName("id") val id: String
)
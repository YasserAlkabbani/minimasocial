package com.yasser.minimasocial.core.network.model.auth_request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefreshTokenBodyRequest(
    @SerialName("refresh_token") val refreshToken: String
)
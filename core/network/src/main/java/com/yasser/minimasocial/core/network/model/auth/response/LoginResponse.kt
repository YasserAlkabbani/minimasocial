package com.yasser.minimasocial.core.network.model.auth.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.yasser.minimasocial.core.network.model.auth.UserNetwork

@JsonClass(generateAdapter = true)
data class LoginResponse(
    @Json(name = "access_token") val accessToken: String,
    @Json(name = "refresh_token") val refreshToken: String,
    @Json(name = "token_type") val tokenType: String,
    @Json(name = "expires_in") val expiresIn: Int,
    @Json(name = "expires_at") val expiresAt: Long,
    @Json(name = "user") val user: UserNetwork,
)
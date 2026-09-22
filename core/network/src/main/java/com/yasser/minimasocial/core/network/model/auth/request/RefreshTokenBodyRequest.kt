package com.yasser.minimasocial.core.network.model.auth.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RefreshTokenBodyRequest(
    @Json(name = "refresh_token") val refreshToken: String
)
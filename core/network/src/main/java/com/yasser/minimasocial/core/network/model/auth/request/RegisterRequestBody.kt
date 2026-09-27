package com.yasser.minimasocial.core.network.model.auth.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class RegisterRequestBody(
    @Json(name = "email") val email: String,
    @Json(name = "password") val password: String,
)
package com.yasser.minimasocial.core.network.model.auth

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserNetwork(
    @Json(name = "id") val id: String,
    @Json(name = "email") val email: String,
    @Json(name = "phone") val phone: String,
    @Json(name = "user_metadata") val userMetadata: UserMetadata,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
) {
    @JsonClass(generateAdapter = true)
    data class UserMetadata(
        @Json(name = "email_verified") val emailVerified: Boolean,
    )
}


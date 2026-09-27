package com.yasser.minimasocial.core.network.model.auth.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RegisterResponse(
    @Json(name = "id") val id: String,
    @Json(name = "email") val email: String,
    @Json(name = "phone") val phone: String,
    @Json(name = "confirmation_sent_at") val confirmationSentAt: String? = null,
    @Json(name = "user_metadata") val userMetadata: UserMetadata,
    @Json(name = "created_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String,
) {
    @JsonClass(generateAdapter = true)
    data class UserMetadata(
        @Json(name = "email") val email: String,
        @Json(name = "email_verified") val emailVerified: Boolean,
        @Json(name = "phone_verified") val phoneVerified: Boolean,
    )
}


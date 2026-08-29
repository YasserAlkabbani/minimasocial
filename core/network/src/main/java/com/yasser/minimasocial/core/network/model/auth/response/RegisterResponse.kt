package com.yasser.minimasocial.core.network.model.auth.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponse(
    @SerialName("id") val id: String,
    @SerialName("email") val email: String,
    @SerialName("phone") val phone: String,
    @SerialName("confirmation_sent_at") val confirmationSentAt: String? = null,
    @SerialName("user_metadata") val userMetadata: UserMetadata,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
)

@Serializable
data class UserMetadata(
    @SerialName("email") val email: String,
    @SerialName("email_verified") val emailVerified: Boolean,
    @SerialName("phone_verified") val phoneVerified: Boolean,
)
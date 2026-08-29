package com.yasser.minimasocial.core.network.model.auth.response

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("id") val id: String,
    @SerialName("email") val email: String,
    @SerialName("phone") val phone: String,
    @SerialName("user_metadata") val userMetadata: UserMetadataResponse,
    @SerialName("created_at") val createdAt: String,
    @SerialName("updated_at") val updatedAt: String,
) {
    @Serializable
    data class UserMetadataResponse(
        @SerialName("email_verified") val emailVerified: Boolean,
    )
}


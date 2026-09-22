package com.yasser.minimasocial.core.network.model.post.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostNetwork (
    @Json(name = "id") val id: String,
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String,
    @Json(name = "user_id") val userID: String,
    @Json(name = "crerated_at") val createdAt: String,
    @Json(name = "updated_at") val updatedAt: String
)
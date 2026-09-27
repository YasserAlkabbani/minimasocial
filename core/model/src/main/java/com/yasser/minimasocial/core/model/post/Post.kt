package com.yasser.minimasocial.core.model.post

import com.yasser.minimasocial.core.common.request_result.SyncState

data class Post(
    val id: String,
    val title: String,
    val content: String,
    val userID: String,
    val createdAt: Long,
    val updatedAt: Long,
    val syncState: SyncState,
)
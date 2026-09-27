package com.yasser.minimasocial.core.data.model

import com.yasser.minimasocial.core.common.isoToTimestampMillis
import com.yasser.minimasocial.core.common.request_result.SyncState
import com.yasser.minimasocial.core.database.model.PostEntity
import com.yasser.minimasocial.core.model.post.Post
import com.yasser.minimasocial.core.network.model.post.response.PostNetwork

fun PostNetwork.asEntity() = PostEntity(
    id = id,
    title = title,
    content = content,
    userID = userID,
    createdAt = createdAt.isoToTimestampMillis(),
    updatedAt = updatedAt.isoToTimestampMillis(),
    syncState = SyncState.SYNCED,
)

fun PostEntity.asModel() = Post(
    id = id,
    title = title,
    content = content,
    userID = userID,
    createdAt = createdAt,
    updatedAt = updatedAt,
    syncState = SyncState.SYNCED,
)
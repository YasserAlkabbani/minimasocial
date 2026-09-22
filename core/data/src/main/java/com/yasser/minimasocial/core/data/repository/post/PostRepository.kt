package com.yasser.minimasocial.core.data.repository.post

import androidx.paging.PagingData
import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.database.model.PostEntity
import com.yasser.minimasocial.core.model.post.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    suspend fun createPost(
        currentUserID: String,
        title: String,
        content: String
    ): Post

    suspend fun syncPost(
        postID: String,
        title: String,
        content: String
    ): RequestResult<Post>

    fun getUnSyncedPosts(): Flow<Post>

    fun getPostsPagingData(): Flow<PagingData<Post>>
}
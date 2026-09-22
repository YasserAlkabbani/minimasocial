package com.yasser.minimasocial.core.data.repository.post

import androidx.paging.PagingData
import com.yasser.minimasocial.core.common.currentTimeInMilliSec
import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.common.request_result.SyncState
import com.yasser.minimasocial.core.data.extentions.asPagingData
import com.yasser.minimasocial.core.data.extentions.mapFlow
import com.yasser.minimasocial.core.data.extentions.mapObject
import com.yasser.minimasocial.core.data.extentions.mapSuccessResult
import com.yasser.minimasocial.core.data.extentions.withObject
import com.yasser.minimasocial.core.data.extentions.withSuccessResult
import com.yasser.minimasocial.core.data.model.asEntity
import com.yasser.minimasocial.core.data.model.asModel
import com.yasser.minimasocial.core.database.dao.PostDao
import com.yasser.minimasocial.core.database.model.PostEntity
import com.yasser.minimasocial.core.model.post.Post
import com.yasser.minimasocial.core.network.data_source.post.PostNetworkDataSource
import com.yasser.minimasocial.core.network.model.post.request.CreatePostRequestBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject
import kotlin.uuid.Uuid

class OfflineFirstPostRepository @Inject constructor(
    val postNetworkDataSource: PostNetworkDataSource,
    val postDao: PostDao
) : PostRepository {

    override suspend fun createPost(
        currentUserID: String,
        title: String,
        content: String
    ): Post = PostEntity(
        id = Uuid.random().toString(),
        title = title,
        content = content,
        userID = currentUserID,
        createdAt = currentTimeInMilliSec(),
        updatedAt = currentTimeInMilliSec(),
        syncState = SyncState.PENDING,
    )
        .withObject { postDao.upsert(this) }
        .mapObject { asModel() }

    override suspend fun syncPost(
        postID: String,
        title: String,
        content: String
    ): RequestResult<Post> = postNetworkDataSource
        .createPost(
            CreatePostRequestBody(
                id = postID,
                title = title,
                content = content
            )
        )
        .mapSuccessResult { asEntity() }
        .withSuccessResult { postDao.upsert(this) }
        .mapSuccessResult { asModel() }

    override fun getUnSyncedPosts() = postDao
        .getPostsBySyncState(listOf(SyncState.PENDING, SyncState.FAILED))
        .filterNotNull()
        .mapFlow { asModel() }

    override fun getPostsPagingData(): Flow<PagingData<Post>> = { postDao.getPostsPagingSource() }
        .asPagingData { asModel() }

}
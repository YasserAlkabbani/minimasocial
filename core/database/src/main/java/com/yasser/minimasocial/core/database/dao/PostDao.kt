package com.yasser.minimasocial.core.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.yasser.minimasocial.core.common.request_result.SyncState
import com.yasser.minimasocial.core.database.model.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Upsert
    suspend fun upsert(post: PostEntity)

    @Query("SELECT * FROM post WHERE sync_state IN (:syncState)")
    fun getPostsBySyncState(syncState: List<SyncState>): Flow<PostEntity?>

    @Query("SELECT * FROM post WHERE id = :postID")
    fun getPostByID(postID: String): Flow<PostEntity>

    @Query("SELECT * FROM post")
    fun getPostsPagingSource(): PagingSource<Int, PostEntity>

}
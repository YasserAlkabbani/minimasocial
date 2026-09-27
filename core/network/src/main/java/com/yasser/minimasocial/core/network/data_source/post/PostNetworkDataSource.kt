package com.yasser.minimasocial.core.network.data_source.post

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.network.model.post.response.PostNetwork
import com.yasser.minimasocial.core.network.model.post.request.CreatePostRequestBody

interface PostNetworkDataSource {

    suspend fun createPost(
        createPostRequestBody: CreatePostRequestBody
    ): RequestResult<PostNetwork>

    suspend fun updatePost()

    suspend fun getPost()

    suspend fun fitchPosts()

}
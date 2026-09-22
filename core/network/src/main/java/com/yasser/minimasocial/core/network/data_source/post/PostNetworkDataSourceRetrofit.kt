package com.yasser.minimasocial.core.network.data_source.post

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.network.model.post.response.PostNetwork
import com.yasser.minimasocial.core.network.model.post.request.CreatePostRequestBody
import com.yasser.minimasocial.core.network.requestWithResult
import com.yasser.minimasocial.core.network.retrofit.PostNetworkRetrofitApi
import javax.inject.Inject

class PostNetworkDataSourceRetrofit @Inject constructor(
    private val postNetworkRetrofitApi: PostNetworkRetrofitApi
) : PostNetworkDataSource {

    override suspend fun createPost(
        createPostRequestBody: CreatePostRequestBody
    ): RequestResult<PostNetwork> = requestWithResult {
        postNetworkRetrofitApi.createPost(
            createPostRequestBody
        )
    }

    override suspend fun updatePost() {
        TODO("Not yet implemented")
    }

    override suspend fun getPost() {
        TODO("Not yet implemented")
    }

    override suspend fun fitchPosts() {
        TODO("Not yet implemented")
    }
}
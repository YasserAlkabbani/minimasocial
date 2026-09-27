package com.yasser.minimasocial.core.network.retrofit

import com.yasser.minimasocial.core.network.model.post.response.PostNetwork
import com.yasser.minimasocial.core.network.model.post.request.CreatePostRequestBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PostNetworkRetrofitApi {

    @Headers("Prefer: return=representation, next=single")
    @POST("rest/v1/post")
    suspend fun createPost(
        @Body createPostRequestBody: CreatePostRequestBody
    ): PostNetwork

}
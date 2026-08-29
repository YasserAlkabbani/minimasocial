package com.yasser.minimasocial.core.network.data_source.post

interface PostNetworkDataSource {

    suspend fun createPost()

    suspend fun updatePost()

    suspend fun getPost()

    suspend fun fitchPosts()

}
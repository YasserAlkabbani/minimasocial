package com.yasser.minimasocial.core.network.retrofit

import com.yasser.minimasocial.core.network.model.auth.UserNetwork
import retrofit2.http.GET

interface UserNetworkRetrofitApi {

    @GET("auth/v1/user")
    suspend fun refreshUser(): UserNetwork

}
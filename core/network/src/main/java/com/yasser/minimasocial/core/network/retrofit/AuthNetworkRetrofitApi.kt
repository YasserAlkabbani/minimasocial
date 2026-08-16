package com.yasser.minimasocial.core.network.retrofit

import com.yasser.minimasocial.core.network.model.auth_request.LoginBodyRequest
import com.yasser.minimasocial.core.network.model.auth_request.LoginResponse
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenBodyRequest
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenResponse
import com.yasser.minimasocial.core.network.model.auth_request.RegisterBodyRequest
import com.yasser.minimasocial.core.network.model.auth_request.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface AuthNetworkRetrofitApi {

    @POST("auth/v1/signup")
    suspend fun signup(
        @Body body: RegisterBodyRequest
    ): RegisterResponse

    @POST("auth/v1/token?grant_type=password")
    suspend fun login(
        @Body body: LoginBodyRequest
    ): LoginResponse

    @POST("auth/v1/token?grant_type=refresh_token")
    suspend fun refreshAccessToken(
        @Body body: RefreshTokenBodyRequest
    ): RefreshTokenResponse

    @POST("auth/v1/logout")
    suspend fun logout()


    @POST("auth/v1/token?grant_type=refresh_token")
    fun refreshAccessTokenCallBack(
        @Header("apikey") apiKey: String,
        @Body body: RefreshTokenBodyRequest
    ): Call<RefreshTokenResponse>

}
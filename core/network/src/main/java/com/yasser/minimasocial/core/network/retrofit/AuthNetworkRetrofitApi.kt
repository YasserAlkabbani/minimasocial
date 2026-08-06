package com.yasser.minimasocial.core.network.retrofit

import com.yasser.minimasocial.core.network.model.auth_request.LoginRequest
import com.yasser.minimasocial.core.network.model.auth_request.LoginResponse
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenRequest
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenResponse
import com.yasser.minimasocial.core.network.model.auth_request.SignupRequest
import com.yasser.minimasocial.core.network.model.auth_request.SignupResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface AuthNetworkRetrofitApi {

    @POST("auth/v1/signup")
    suspend fun signup(
        @Body body: SignupRequest
    ): SignupResponse

    @POST("auth/v1/token?grant_type=password")
    suspend fun login(
        @Body body: LoginRequest
    ): LoginResponse

    @POST("auth/v1/token?grant_type=refresh_token")
    suspend fun refreshAccessToken(
        @Body body: RefreshTokenRequest
    ): RefreshTokenResponse

    @POST("auth/v1/logout")
    suspend fun logout()


    @POST("auth/v1/token?grant_type=refresh_token")
    fun refreshAccessTokenCallBack(
        @Header("apikey") apiKey: String,
        @Body body: RefreshTokenRequest
    ): Call<RefreshTokenResponse>

}
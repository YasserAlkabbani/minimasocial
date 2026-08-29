package com.yasser.minimasocial.core.network.retrofit

import com.yasser.minimasocial.core.network.model.auth.request.LoginRequestBody
import com.yasser.minimasocial.core.network.model.auth.response.LoginResponse
import com.yasser.minimasocial.core.network.model.auth.request.RefreshTokenBodyRequest
import com.yasser.minimasocial.core.network.model.auth.response.RefreshTokenResponse
import com.yasser.minimasocial.core.network.model.auth.request.RegisterRequestBody
import com.yasser.minimasocial.core.network.model.auth.response.RegisterResponse
import com.yasser.minimasocial.core.network.model.auth.response.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST


interface AuthNetworkRetrofitApi {

    @POST("auth/v1/signup")
    suspend fun signup(
        @Body body: RegisterRequestBody
    ): RegisterResponse

    @POST("auth/v1/token?grant_type=password")
    suspend fun login(
        @Body body: LoginRequestBody
    ): LoginResponse

    @GET("auth/v1/user")
    suspend fun refreshUser(): UserResponse

    @POST("auth/v1/logout")
    suspend fun logout(): Boolean

    @POST("auth/v1/token?grant_type=refresh_token")
    fun refreshAccessTokenCallBack(
        @Header("apikey") apiKey: String,
        @Body body: RefreshTokenBodyRequest
    ): Call<RefreshTokenResponse>

}
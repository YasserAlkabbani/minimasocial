package com.yasser.minimasocial.core.network.data_source.auth

import com.yasser.minimasocial.core.network.model.auth_request.LoginBodyRequest
import com.yasser.minimasocial.core.network.model.auth_request.LoginResponse
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenBodyRequest
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenResponse
import com.yasser.minimasocial.core.network.model.auth_request.RegisterBodyRequest
import com.yasser.minimasocial.core.network.model.auth_request.RegisterResponse
import com.yasser.minimasocial.core.network.retrofit.AuthNetworkRetrofitApi
import javax.inject.Inject

class AuthNetworkDataSourceRetrofit @Inject constructor(
    private val authNetworkRetrofitApi: AuthNetworkRetrofitApi
) : AuthNetworkDataSource {

    override suspend fun login(
        loginBodyRequest: LoginBodyRequest
    ): LoginResponse =
        authNetworkRetrofitApi.login(loginBodyRequest)

    override suspend fun register(
        registerBodyRequest: RegisterBodyRequest
    ): RegisterResponse =
        authNetworkRetrofitApi.signup(registerBodyRequest)

    override suspend fun refreshAccessToken(
        refreshTokenBodyRequest: RefreshTokenBodyRequest
    ): RefreshTokenResponse =
        authNetworkRetrofitApi.refreshAccessToken(refreshTokenBodyRequest)

    override suspend fun logout() =
        authNetworkRetrofitApi.logout()

}
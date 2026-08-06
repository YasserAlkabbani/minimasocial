package com.yasser.minimasocial.core.network.data_source.auth

import com.yasser.minimasocial.core.network.model.auth_request.LoginRequest
import com.yasser.minimasocial.core.network.model.auth_request.LoginResponse
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenRequest
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenResponse
import com.yasser.minimasocial.core.network.model.auth_request.SignupRequest
import com.yasser.minimasocial.core.network.model.auth_request.SignupResponse
import com.yasser.minimasocial.core.network.retrofit.AuthNetworkRetrofitApi
import javax.inject.Inject

class AuthNetworkDataSourceRetrofit @Inject constructor(
    private val authNetworkRetrofitApi: AuthNetworkRetrofitApi
) : AuthNetworkDataSource {

    override suspend fun signup(signupRequest: SignupRequest): SignupResponse =
        authNetworkRetrofitApi.signup(signupRequest)

    override suspend fun login(loginRequest: LoginRequest): LoginResponse =
        authNetworkRetrofitApi.login(loginRequest)

    override suspend fun refreshAccessToken(refreshTokenRequest: RefreshTokenRequest): RefreshTokenResponse =
        authNetworkRetrofitApi.refreshAccessToken(refreshTokenRequest)

    override suspend fun logout() =
        authNetworkRetrofitApi.logout()

}
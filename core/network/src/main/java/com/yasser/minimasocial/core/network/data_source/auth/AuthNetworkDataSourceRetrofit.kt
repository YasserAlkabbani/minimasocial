package com.yasser.minimasocial.core.network.data_source.auth

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.network.model.auth.response.LoginResponse
import com.yasser.minimasocial.core.network.model.auth.request.LoginRequestBody
import com.yasser.minimasocial.core.network.model.auth.request.RegisterRequestBody
import com.yasser.minimasocial.core.network.model.auth.response.RegisterResponse
import com.yasser.minimasocial.core.network.model.auth.response.UserResponse
import com.yasser.minimasocial.core.network.requestWithResult
import com.yasser.minimasocial.core.network.retrofit.AuthNetworkRetrofitApi
import javax.inject.Inject

class AuthNetworkDataSourceRetrofit @Inject constructor(
    private val authNetworkRetrofitApi: AuthNetworkRetrofitApi
) : AuthNetworkDataSource {

    override suspend fun register(
        registerRequestBody: RegisterRequestBody
    ): RequestResult<RegisterResponse> = requestWithResult {
        authNetworkRetrofitApi.signup(registerRequestBody)
    }

    override suspend fun login(
        loginRequestBody: LoginRequestBody
    ): RequestResult<LoginResponse> = requestWithResult {
        authNetworkRetrofitApi.login(loginRequestBody)
    }

    override suspend fun refreshUser(): RequestResult<UserResponse> = requestWithResult {
        authNetworkRetrofitApi.refreshUser()
    }

    override suspend fun logout(): RequestResult<Boolean> = requestWithResult {
        authNetworkRetrofitApi.logout()
    }

}
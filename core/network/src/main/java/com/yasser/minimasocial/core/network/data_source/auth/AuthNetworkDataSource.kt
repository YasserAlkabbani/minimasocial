package com.yasser.minimasocial.core.network.data_source.auth

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.network.model.auth.response.LoginResponse
import com.yasser.minimasocial.core.network.model.auth.request.LoginRequestBody
import com.yasser.minimasocial.core.network.model.auth.request.RegisterRequestBody
import com.yasser.minimasocial.core.network.model.auth.response.RegisterResponse
import com.yasser.minimasocial.core.network.model.auth.response.UserResponse

interface AuthNetworkDataSource {

    suspend fun register(
        registerRequestBody: RegisterRequestBody
    ): RequestResult<RegisterResponse>

    suspend fun login(
        loginRequestBody: LoginRequestBody
    ): RequestResult<LoginResponse>

    suspend fun refreshUser(): RequestResult<UserResponse>

    suspend fun logout(): RequestResult<Boolean>

}
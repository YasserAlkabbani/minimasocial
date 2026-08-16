package com.yasser.minimasocial.core.network.data_source.auth

import com.yasser.minimasocial.core.network.model.auth_request.LoginBodyRequest
import com.yasser.minimasocial.core.network.model.auth_request.LoginResponse
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenBodyRequest
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenResponse
import com.yasser.minimasocial.core.network.model.auth_request.RegisterBodyRequest
import com.yasser.minimasocial.core.network.model.auth_request.RegisterResponse

interface AuthNetworkDataSource {

    suspend fun login(
        loginBodyRequest: LoginBodyRequest
    ): LoginResponse

    suspend fun register(
        registerBodyRequest: RegisterBodyRequest
    ): RegisterResponse

    suspend fun refreshAccessToken(
        refreshTokenBodyRequest: RefreshTokenBodyRequest
    ): RefreshTokenResponse

    suspend fun logout()

}
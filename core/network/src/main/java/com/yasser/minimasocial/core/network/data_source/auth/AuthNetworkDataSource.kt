package com.yasser.minimasocial.core.network.data_source.auth

import com.yasser.minimasocial.core.network.model.auth_request.LoginRequest
import com.yasser.minimasocial.core.network.model.auth_request.LoginResponse
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenRequest
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenResponse
import com.yasser.minimasocial.core.network.model.auth_request.SignupRequest
import com.yasser.minimasocial.core.network.model.auth_request.SignupResponse

interface AuthNetworkDataSource {

    suspend fun signup(
        signupRequest: SignupRequest
    ): SignupResponse

    suspend fun login(
        loginRequest: LoginRequest
    ): LoginResponse

    suspend fun refreshAccessToken(
        refreshTokenRequest: RefreshTokenRequest
    ): RefreshTokenResponse

    suspend fun logout()

}
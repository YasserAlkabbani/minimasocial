package com.yasser.minimasocial.core.data.repository.auth

import com.yasser.minimasocial.core.common.request_result.RequestState
import com.yasser.minimasocial.core.model.AuthState
import com.yasser.minimasocial.core.network.model.auth_request.LoginResponse
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenResponse
import com.yasser.minimasocial.core.network.model.auth_request.RegisterResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun login(email: String, password: String): Flow<RequestState<LoginResponse>>

    fun register(email: String, password: String): Flow<RequestState<RegisterResponse>>

    fun refreshToken(refreshToken: String): Flow<RequestState<RefreshTokenResponse>>

    fun logout(): Flow<RequestState<Unit>>

    fun authState(): Flow<AuthState>

}
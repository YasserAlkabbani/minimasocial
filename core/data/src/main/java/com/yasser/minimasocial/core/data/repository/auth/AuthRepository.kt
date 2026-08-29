package com.yasser.minimasocial.core.data.repository.auth

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.model.AuthState
import com.yasser.minimasocial.core.model.Login
import com.yasser.minimasocial.core.model.MSUser
import com.yasser.minimasocial.core.model.Register
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun login(
        email: String,
        password: String
    ): RequestResult<Login>

    suspend fun register(
        email: String,
        password: String
    ): RequestResult<Register>

    suspend fun refreshUser(): RequestResult<MSUser>

    suspend fun logout(): RequestResult<Boolean>

    suspend fun saveToken(
        accessToken: String,
        refreshToken: String
    )

    suspend fun clearToken()

    fun authState(): Flow<AuthState>

}
package com.yasser.minimasocial.core.data.repository.auth

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.model.auth.AuthState
import com.yasser.minimasocial.core.model.user.MSUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun login(
        email: String,
        password: String
    ): RequestResult<MSUser>

    suspend fun register(
        email: String,
        password: String
    ): RequestResult<MSUser>

    suspend fun logout(): RequestResult<Boolean>

    fun authState(): Flow<AuthState>

}
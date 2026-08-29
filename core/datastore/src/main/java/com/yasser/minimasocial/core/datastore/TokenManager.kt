package com.yasser.minimasocial.core.datastore

import kotlinx.coroutines.flow.Flow

interface TokenManager {

    suspend fun saveTokens(accessToken: String, refreshToken: String)

    suspend fun getAccessToken(): String?

    suspend fun getRefreshToken(): String?

    suspend fun clearTokens()

    fun isLoggedIn(): Flow<Boolean>

}
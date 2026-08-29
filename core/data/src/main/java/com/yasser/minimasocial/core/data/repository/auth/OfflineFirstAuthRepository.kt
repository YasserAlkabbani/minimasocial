package com.yasser.minimasocial.core.data.repository.auth

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.data.mapTo
import com.yasser.minimasocial.core.data.model.asAuthState
import com.yasser.minimasocial.core.data.model.asModel
import com.yasser.minimasocial.core.datastore.TokenManager
import com.yasser.minimasocial.core.model.AuthState
import com.yasser.minimasocial.core.model.Login
import com.yasser.minimasocial.core.model.MSUser
import com.yasser.minimasocial.core.model.Register
import com.yasser.minimasocial.core.network.data_source.auth.AuthNetworkDataSource
import com.yasser.minimasocial.core.network.model.auth.request.LoginRequestBody
import com.yasser.minimasocial.core.network.model.auth.request.RegisterRequestBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstAuthRepository @Inject constructor(
    private val authNetworkDataSource: AuthNetworkDataSource,
    private val tokenManager: TokenManager
) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): RequestResult<Login> = authNetworkDataSource.login(
        LoginRequestBody(
            email = email,
            password = password
        )
    ).mapTo { asModel() }

    override suspend fun register(
        email: String,
        password: String
    ): RequestResult<Register> = authNetworkDataSource.register(
        RegisterRequestBody(
            email = email,
            password = password
        )
    ).mapTo { asModel() }


    override suspend fun refreshUser(): RequestResult<MSUser> =
        authNetworkDataSource.refreshUser().mapTo { asModel() }

    override suspend fun logout() = authNetworkDataSource.logout()

    override suspend fun saveToken(accessToken: String, refreshToken: String) =
        tokenManager.saveTokens(
            accessToken = accessToken,
            refreshToken = refreshToken
        )

    override suspend fun clearToken() = tokenManager.clearTokens()

    override fun authState(): Flow<AuthState> =
        tokenManager.isLoggedIn().map { it.asAuthState() }.distinctUntilChanged()

}
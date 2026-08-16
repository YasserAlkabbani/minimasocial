package com.yasser.minimasocial.core.data.repository.auth

import com.yasser.minimasocial.core.common.request_result.RequestState
import com.yasser.minimasocial.core.common.request_result.requestWithState
import com.yasser.minimasocial.core.data.model.asAuthState
import com.yasser.minimasocial.core.datastore.TokenManager
import com.yasser.minimasocial.core.model.AuthState
import com.yasser.minimasocial.core.network.data_source.auth.AuthNetworkDataSource
import com.yasser.minimasocial.core.network.model.auth_request.LoginBodyRequest
import com.yasser.minimasocial.core.network.model.auth_request.LoginResponse
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenBodyRequest
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenResponse
import com.yasser.minimasocial.core.network.model.auth_request.RegisterBodyRequest
import com.yasser.minimasocial.core.network.model.auth_request.RegisterResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstAuthRepository @Inject constructor(
    private val authNetworkDataSource: AuthNetworkDataSource,
    private val tokenManager: TokenManager
) : AuthRepository {

    override fun login(
        email: String,
        password: String
    ): Flow<RequestState<LoginResponse>> =
        requestWithState {
            authNetworkDataSource.login(
                LoginBodyRequest(
                    email = email,
                    password = password
                )
            )
        }

    override fun register(
        email: String,
        password: String
    ): Flow<RequestState<RegisterResponse>> =
        requestWithState {
            authNetworkDataSource.register(
                RegisterBodyRequest(
                    email = email,
                    password = password
                )
            )
        }

    override fun refreshToken(
        refreshToken: String
    ): Flow<RequestState<RefreshTokenResponse>> =
        requestWithState {
            authNetworkDataSource.refreshAccessToken(
                RefreshTokenBodyRequest(
                    refreshToken = refreshToken
                )
            )
        }

    override fun logout(): Flow<RequestState<Unit>> = requestWithState {
        authNetworkDataSource.logout()
        tokenManager.clearTokens()
    }

    override fun authState(): Flow<AuthState> =
        tokenManager.isLoggedIn().map { it.asAuthState() }.distinctUntilChanged()

}
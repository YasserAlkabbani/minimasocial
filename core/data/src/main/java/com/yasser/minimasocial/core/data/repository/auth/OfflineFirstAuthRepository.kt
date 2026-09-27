package com.yasser.minimasocial.core.data.repository.auth

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.data.extentions.mapSuccessResult
import com.yasser.minimasocial.core.data.extentions.withSuccessResult
import com.yasser.minimasocial.core.data.model.asAuthState
import com.yasser.minimasocial.core.data.model.asModel
import com.yasser.minimasocial.core.data.model.asUserEntity
import com.yasser.minimasocial.core.database.dao.UserDao
import com.yasser.minimasocial.core.datastore.TokenManager
import com.yasser.minimasocial.core.model.auth.AuthState
import com.yasser.minimasocial.core.model.user.MSUser
import com.yasser.minimasocial.core.network.data_source.auth.AuthNetworkDataSource
import com.yasser.minimasocial.core.network.model.auth.request.LoginRequestBody
import com.yasser.minimasocial.core.network.model.auth.request.RegisterRequestBody
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstAuthRepository @Inject constructor(
    private val authNetworkDataSource: AuthNetworkDataSource,
    private val userDao: UserDao,
    private val tokenManager: TokenManager
) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): RequestResult<MSUser> = authNetworkDataSource
        .login(
            LoginRequestBody(
                email = email,
                password = password
            )
        )
        .withSuccessResult {
            tokenManager.saveTokens(
                accessToken = accessToken,
                refreshToken = refreshToken
            )
        }
        .mapSuccessResult { asUserEntity() }
        .withSuccessResult { userDao.upsertUser(this) }
        .mapSuccessResult { asModel() }

    override suspend fun register(
        email: String,
        password: String
    ): RequestResult<MSUser> = authNetworkDataSource
        .register(
            RegisterRequestBody(
                email = email,
                password = password
            )
        )
        .mapSuccessResult { asUserEntity() }
        .withSuccessResult { userDao.upsertUser(this) }
        .mapSuccessResult { asModel() }

    override suspend fun logout() = authNetworkDataSource
        .logout()
        .withSuccessResult {
            tokenManager.clearTokens()
        }


    override fun authState(): Flow<AuthState> = tokenManager
        .isLoggedIn()
        .map { it.asAuthState() }
        .distinctUntilChanged()

}
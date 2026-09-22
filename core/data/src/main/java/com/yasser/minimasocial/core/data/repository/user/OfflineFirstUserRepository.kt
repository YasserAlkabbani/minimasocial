package com.yasser.minimasocial.core.data.repository.user

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.data.extentions.mapObject
import com.yasser.minimasocial.core.data.extentions.mapSuccessResult
import com.yasser.minimasocial.core.data.extentions.withSuccessResult
import com.yasser.minimasocial.core.data.model.asEntity
import com.yasser.minimasocial.core.data.model.asModel
import com.yasser.minimasocial.core.database.dao.UserDao
import com.yasser.minimasocial.core.model.user.MSUser
import com.yasser.minimasocial.core.network.data_source.user.UserNetworkDataSource
import jakarta.inject.Inject

class OfflineFirstUserRepository @Inject constructor(
    private val userNetworkDataSource: UserNetworkDataSource,
    private val userDao: UserDao
) : UserRepository {

    override suspend fun refreshUser(): RequestResult<MSUser> = userNetworkDataSource
        .refreshUser()
        .mapSuccessResult { asEntity(id) }
        .withSuccessResult { userDao.upsertUser(this) }
        .mapSuccessResult { asModel() }

    override suspend fun getCurrentUser(): MSUser = userDao
        .getCurrentUser()
        .mapObject { asModel() }

    override suspend fun getUserByID(userID: String): MSUser = userDao
        .getCurrentUser()
        .mapObject { asModel() }
}
package com.yasser.minimasocial.core.data.repository.user

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.model.user.MSUser

interface UserRepository {

    suspend fun refreshUser(): RequestResult<MSUser>

    suspend fun getCurrentUser(): MSUser

    suspend fun getUserByID(userID: String): MSUser

}
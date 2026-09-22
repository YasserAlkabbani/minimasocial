package com.yasser.minimasocial.core.network.data_source.user

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.network.model.auth.UserNetwork
import com.yasser.minimasocial.core.network.requestWithResult

interface UserNetworkDataSource {

    suspend fun refreshUser(): RequestResult<UserNetwork>

}
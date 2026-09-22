package com.yasser.minimasocial.core.network.data_source.user

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.network.model.auth.UserNetwork
import com.yasser.minimasocial.core.network.requestWithResult
import com.yasser.minimasocial.core.network.retrofit.UserNetworkRetrofitApi
import javax.inject.Inject

class UserNetworkDataSourceRetrofit @Inject constructor(
    private val userNetworkRetrofitApi: UserNetworkRetrofitApi
) : UserNetworkDataSource {

    override suspend fun refreshUser(): RequestResult<UserNetwork> = requestWithResult {
        userNetworkRetrofitApi.refreshUser()
    }

}
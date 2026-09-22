package com.yasser.minimasocial.core.network.di

import com.yasser.minimasocial.core.network.data_source.auth.AuthNetworkDataSource
import com.yasser.minimasocial.core.network.data_source.auth.AuthNetworkDataSourceRetrofit
import com.yasser.minimasocial.core.network.data_source.post.PostNetworkDataSource
import com.yasser.minimasocial.core.network.data_source.post.PostNetworkDataSourceRetrofit
import com.yasser.minimasocial.core.network.data_source.user.UserNetworkDataSource
import com.yasser.minimasocial.core.network.data_source.user.UserNetworkDataSourceRetrofit
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
internal abstract class NetworkDataSourceModule {

    @Binds
    internal abstract fun bindAuthNetworkDataSource(
        authNetworkDataSourceRetrofit: AuthNetworkDataSourceRetrofit
    ): AuthNetworkDataSource

    @Binds
    internal abstract fun bindPostNetworkDataSource(
        postNetworkDataSourceRetrofit: PostNetworkDataSourceRetrofit
    ): PostNetworkDataSource


    @Binds
    internal abstract fun bindUserNetworkDataSource(
        userNetworkDataSourceRetrofit: UserNetworkDataSourceRetrofit
    ): UserNetworkDataSource

}
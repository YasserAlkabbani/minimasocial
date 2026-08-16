package com.yasser.minimasocial.core.network.di

import com.yasser.minimasocial.core.network.data_source.auth.AuthNetworkDataSource
import com.yasser.minimasocial.core.network.data_source.auth.AuthNetworkDataSourceRetrofit
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

}
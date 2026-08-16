package com.yasser.minimasocial.core.data.di

import com.yasser.minimasocial.core.data.repository.auth.AuthRepository
import com.yasser.minimasocial.core.data.repository.auth.OfflineFirstAuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindAuthRepository(
        offlineFirstAuthRepository: OfflineFirstAuthRepository
    ): AuthRepository

}
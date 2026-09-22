package com.yasser.minimasocial.core.data.di

import com.yasser.minimasocial.core.data.repository.auth.AuthRepository
import com.yasser.minimasocial.core.data.repository.auth.OfflineFirstAuthRepository
import com.yasser.minimasocial.core.data.repository.post.OfflineFirstPostRepository
import com.yasser.minimasocial.core.data.repository.post.PostRepository
import com.yasser.minimasocial.core.data.repository.user.OfflineFirstUserRepository
import com.yasser.minimasocial.core.data.repository.user.UserRepository
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

    @Binds
    internal abstract fun bindPostRepository(
        offlineFirstPostRepository: OfflineFirstPostRepository
    ): PostRepository

    @Binds
    internal abstract fun bindUserRepositoy(
        offlineFirstUserRepository: OfflineFirstUserRepository
    ): UserRepository

}
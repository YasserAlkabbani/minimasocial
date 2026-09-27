package com.yasser.minimasocial.core.database.di

import com.yasser.minimasocial.core.database.MSDataBase
import com.yasser.minimasocial.core.database.dao.PostDao
import com.yasser.minimasocial.core.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    fun providePostDao(msDataBase: MSDataBase): PostDao =
        msDataBase.postDao()

    @Provides
    fun provideUserDao(msDataBase: MSDataBase): UserDao =
        msDataBase.userDao()

}
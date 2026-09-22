package com.yasser.minimasocial.core.database.di

import android.content.Context
import androidx.room.Room
import com.yasser.minimasocial.core.database.MSDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideMSDatabase(
        @ApplicationContext context: Context
    ): MSDataBase = Room.databaseBuilder(
        context = context,
        klass = MSDataBase::class.java,
        name = "ms-database",
    ).build()

}
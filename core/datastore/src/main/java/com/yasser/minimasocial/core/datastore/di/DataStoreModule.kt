package com.yasser.minimasocial.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.yasser.minimasocial.core.datastore.TokenManager
import com.yasser.minimasocial.core.datastore.TokenManagerDataStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private val Context.authDataStore: DataStore<Preferences> by preferencesDataStore(name = "auth_prefs")

@Module
@InstallIn(SingletonComponent::class)
internal object DataStoreObjectModule {

    @Singleton
    @Provides
    fun provideTokenManager(@ApplicationContext context: Context): DataStore<Preferences> =
        context.authDataStore

}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreModule {

    @Binds
    abstract fun bindTokenManager(tokenManagerDataStore: TokenManagerDataStore): TokenManager

}
package com.yasser.minimasocial.core.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class TokenManagerDataStore @Inject constructor(
    private val dataStorePreferences: DataStore<Preferences>,
    private val cryptoManager: CryptoManager
) :
    TokenManager {

    companion object {
        private val ACCESS_TOKEN_KEY = stringPreferencesKey("access_token")
        private val REFRESH_TOKEN_KEY = stringPreferencesKey("refresh_token")
    }

    private val accessToken: Flow<String?> =
        dataStorePreferences.data.map { preferences ->
            preferences[ACCESS_TOKEN_KEY]?.let { encryptedToken ->
                cryptoManager.decrypt(encryptedToken)
            }
        }

    private val refreshToken: Flow<String?> =
        dataStorePreferences.data.map { preferences ->
            preferences[REFRESH_TOKEN_KEY]?.let { encryptedToken ->
                cryptoManager.decrypt(encryptedToken)
            }
        }

    override suspend fun saveTokens(accessToken: String, refreshToken: String) {
        dataStorePreferences.edit { prefs ->
            prefs[ACCESS_TOKEN_KEY] = cryptoManager.encrypt(accessToken)
            prefs[REFRESH_TOKEN_KEY] = cryptoManager.encrypt(refreshToken)
        }
    }

    override suspend fun getAccessToken(): String? =
        accessToken.first()

    override suspend fun getRefreshToken(): String? =
        refreshToken.first()


    override suspend fun clearTokens() {
        dataStorePreferences.edit { prefs ->
            prefs.clear()
        }
    }

    override fun isLoggedIn(): Flow<Boolean> = dataStorePreferences.data.map {
        it[ACCESS_TOKEN_KEY].isNullOrEmpty()
    }

}
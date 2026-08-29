package com.yasser.minimasocial.core.network.di

import android.util.Log
import com.yasser.minimasocial.core.datastore.TokenManager
import com.yasser.minimasocial.core.network.BuildConfig
import com.yasser.minimasocial.core.network.model.auth.request.RefreshTokenBodyRequest
import com.yasser.minimasocial.core.network.model.auth.response.RefreshTokenResponse
import com.yasser.minimasocial.core.network.retrofit.AuthNetworkRetrofitApi
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import javax.inject.Singleton

private const val API_KEY = "apikey"
private const val AUTH_KEY = "Authorization"
private const val BEARER_KEY = "Bearer"

private const val RETRY_COUNT_HEADER = "X-Retry-Count"

private const val LOGIN_URL = "auth/v1/token"
private const val REGISTER_URL = "auth/v1/signup"
private fun String.isAuthTokenRequest() = LOGIN_URL in this || REGISTER_URL in this

private suspend inline fun Response.checkExpireToken(
    getRefreshToken: suspend () -> String?,
    saveTokens: suspend (String, String) -> Unit,
    clearTokens: suspend () -> Unit,
    refreshTokenRequest: suspend (String) -> retrofit2.Response<RefreshTokenResponse>,
    asResponse: Request.() -> Response
): Response {

    val retryCount = header(RETRY_COUNT_HEADER)?.toIntOrNull() ?: 0

    if (retryCount >= 1) return this

    val refreshToken: String? = getRefreshToken()
    if (refreshToken.isNullOrBlank()) return this

    val refreshTokenResponse = try {
        refreshTokenRequest(refreshToken)
    } catch (_: Throwable) {
        return this
    }

    return when (refreshTokenResponse.isSuccessful) {
        true -> {
            val refreshTokenResponseBody = refreshTokenResponse.body() ?: return this

            saveTokens(
                refreshTokenResponseBody.accessToken,
                refreshTokenResponseBody.refreshToken
            )
            close()
            request
                .newBuilder()
                .header(API_KEY, BuildConfig.SUPABASE_KEY)
                .header(
                    name = AUTH_KEY,
                    value = "$BEARER_KEY ${refreshTokenResponseBody.accessToken}"
                )
                .header(RETRY_COUNT_HEADER, "1")
                .build()
                .asResponse()

        }

        false -> {
            if (refreshTokenResponse.code() in 400..403) {
                clearTokens()
            }
            this
        }
    }
}


@Module
@InstallIn(SingletonComponent::class)
internal object NetworkRetrofitModule {

    @Provides
    @Singleton
    fun provideOKHttp(
        tokenManager: TokenManager,
        authNetworkRetrofitApi: Lazy<AuthNetworkRetrofitApi>
    ): OkHttpClient {

        val interceptor: Interceptor = Interceptor { chain ->
            val request = chain.request()
            val requestPath = request.url.encodedPath
            val isAuthRequest: Boolean = requestPath.isAuthTokenRequest()

            val accessToken: String? = runBlocking { tokenManager.getAccessToken() }
            val requestBuilder = request
                .newBuilder()
                .header(API_KEY, BuildConfig.SUPABASE_KEY)

            if (!isAuthRequest) {
                val authToken = when (accessToken.isNullOrBlank()) {
                    true -> BuildConfig.SUPABASE_KEY
                    false -> "$BEARER_KEY $accessToken"
                }
                requestBuilder.header(
                    name = AUTH_KEY,
                    value = authToken
                )
            }

            val response = chain.proceed(requestBuilder.build())


            if (response.code == 401 || response.code == 403) {
                runBlocking {
                    response.checkExpireToken(
                        getRefreshToken = tokenManager::getRefreshToken,
                        saveTokens = tokenManager::saveTokens,
                        clearTokens = tokenManager::clearTokens,
                        refreshTokenRequest = { refreshToken ->
                            authNetworkRetrofitApi.get().refreshAccessTokenCallBack(
                                apiKey = BuildConfig.SUPABASE_KEY,
                                body = RefreshTokenBodyRequest(refreshToken = refreshToken)
                            ).execute()
                        },
                        asResponse = { chain.proceed(this) }
                    )
                }
            } else response
        }

        val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        json: Json,
        okHttpClient: Lazy<OkHttpClient>,
    ): Retrofit = Retrofit
        .Builder()
        .baseUrl(BuildConfig.SUPABASE_URL)
        .callFactory { request -> okHttpClient.get().newCall(request) }
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    @Singleton
    @Provides
    fun provideAuthRetrofit(
        retrofit: Retrofit
    ): AuthNetworkRetrofitApi = retrofit.create<AuthNetworkRetrofitApi>()

}
package com.yasser.minimasocial.core.network.di

import com.yasser.minimasocial.core.datastore.TokenManager
import com.yasser.minimasocial.core.network.BuildConfig
import com.yasser.minimasocial.core.network.model.auth_request.RefreshTokenBodyRequest
import com.yasser.minimasocial.core.network.retrofit.AuthNetworkRetrofitApi
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import javax.inject.Singleton

private const val API_KEY = "apikey"
private const val AUTH_KEY = "Authorization"
private const val BEARER_KEY = "Bearer"

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
            val accessToken: String? = runBlocking { tokenManager.getAccessToken() }
            val updatedRequest = chain
                .request()
                .newBuilder()
                .addHeader(API_KEY, BuildConfig.SUPABASE_KEY)
                .addHeader(
                    name = AUTH_KEY,
                    value = when (accessToken) {
                        null -> "$BEARER_KEY ${BuildConfig.SUPABASE_KEY}"
                        else -> "$BEARER_KEY $accessToken"
                    }
                )
                .build()
            chain.proceed(updatedRequest)
        }

        val authenticator: Authenticator = Authenticator { route, response ->

            val isLoginRequest: Boolean = response.request.url.encodedPath.contains("auth")
            if (isLoginRequest) return@Authenticator null

            val refreshToken: String? = runBlocking { tokenManager.getRefreshToken() }
            if (refreshToken == null) return@Authenticator null

            val refreshTokenResponse =
                authNetworkRetrofitApi.get().refreshAccessTokenCallBack(
                    apiKey = BuildConfig.SUPABASE_KEY,
                    body = RefreshTokenBodyRequest(refreshToken = refreshToken)
                ).execute()

            when (refreshTokenResponse.isSuccessful) {
                true -> {
                    val refreshTokenResponseBody =
                        refreshTokenResponse.body() ?: return@Authenticator null

                    runBlocking {
                        tokenManager.saveTokens(
                            accessToken = refreshTokenResponseBody.accessToken,
                            refreshToken = refreshTokenResponseBody.refreshToken
                        )
                    }

                    response
                        .request
                        .newBuilder()
                        .header(
                            name = AUTH_KEY,
                            value = "$BEARER_KEY ${refreshTokenResponseBody.accessToken}"
                        )
                        .build()
                }

                false -> {
                    runBlocking {
                        tokenManager.clearTokens()
                    }
                    null
                }
            }
        }

        val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .authenticator(authenticator)
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
package com.yasser.minimasocial.core.data.model

import com.yasser.minimasocial.core.model.Login
import com.yasser.minimasocial.core.model.RefreshToken
import com.yasser.minimasocial.core.network.model.auth.response.LoginResponse
import com.yasser.minimasocial.core.network.model.auth.response.RefreshTokenResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

fun RefreshTokenResponse.asModel() = RefreshToken(
    refreshToken = refreshToken,
    accessToken = accessToken
)
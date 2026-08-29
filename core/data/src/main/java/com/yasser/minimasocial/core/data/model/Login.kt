package com.yasser.minimasocial.core.data.model

import com.yasser.minimasocial.core.network.model.auth.response.LoginResponse
import com.yasser.minimasocial.core.model.Login
import com.yasser.minimasocial.core.model.MSUser

fun LoginResponse.asModel() = Login(
    user = user.asModel(),
    accessToken = accessToken,
    refreshToken = refreshToken,
)
package com.yasser.minimasocial.core.data.model

import com.yasser.minimasocial.core.model.Register
import com.yasser.minimasocial.core.network.model.auth.response.RegisterResponse

fun RegisterResponse.asModel() = Register(
    id = id,
    email = email,
    phone = phone,
    createdAt = createdAt,
    updatedAt = updatedAt,
    emailVerified = userMetadata.emailVerified,
    phoneVerified = userMetadata.phoneVerified,
)

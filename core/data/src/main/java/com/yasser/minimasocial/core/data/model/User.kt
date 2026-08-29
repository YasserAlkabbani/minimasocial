package com.yasser.minimasocial.core.data.model

import com.yasser.minimasocial.core.model.MSUser
import com.yasser.minimasocial.core.network.model.auth.response.UserResponse

fun UserResponse.asModel() = MSUser(
    id = id,
    email = email,
    phone = phone,
    emailVerified = userMetadata.emailVerified,
)
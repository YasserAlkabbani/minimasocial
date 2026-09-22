package com.yasser.minimasocial.core.data.model

import com.yasser.minimasocial.core.database.model.UserEntity
import com.yasser.minimasocial.core.model.user.MSUser
import com.yasser.minimasocial.core.network.model.auth.UserNetwork
import com.yasser.minimasocial.core.network.model.auth.response.LoginResponse
import com.yasser.minimasocial.core.network.model.auth.response.RegisterResponse

fun RegisterResponse.asUserEntity() = UserEntity(
    id = id,
    email = email,
    phone = phone,
    emailVerified = userMetadata.emailVerified,
    currentUser = true
)

fun LoginResponse.asUserEntity() = UserEntity(
    id = user.id,
    email = user.email,
    phone = user.phone,
    emailVerified = user.userMetadata.emailVerified,
    currentUser = true
)

fun UserNetwork.asEntity(currentUserID: String) = UserEntity(
    id = id,
    email = email,
    phone = phone,
    emailVerified = userMetadata.emailVerified,
    currentUser = currentUserID == id
)

fun UserEntity.asModel() = MSUser(
    id = id,
    email = email,
    phone = phone,
    emailVerified = emailVerified,
    currentUser = currentUser
)
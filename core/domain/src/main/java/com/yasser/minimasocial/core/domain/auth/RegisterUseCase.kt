package com.yasser.minimasocial.core.domain.auth

import com.yasser.minimasocial.core.common.request_result.RequestError
import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.data.repository.auth.AuthRepository
import com.yasser.minimasocial.core.domain.extensions.isValidEmail
import com.yasser.minimasocial.core.domain.extensions.isValidPassword
import com.yasser.minimasocial.core.model.user.MSUser
import javax.inject.Inject


class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): RequestResult<MSUser> = when {
        !email.isValidEmail() ->
            RequestResult.Error(RequestError.InvalidEmail)

        !password.isValidPassword() ->
            RequestResult.Error(RequestError.InvalidPassword)

        else -> authRepository.register(
            email = email,
            password = password
        )
    }
}
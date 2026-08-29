package com.yasser.minimasocial.core.domain.auth

import com.yasser.minimasocial.core.common.request_result.RequestError
import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.data.repository.auth.AuthRepository
import com.yasser.minimasocial.core.domain.auth.extensions.isValidEmail
import com.yasser.minimasocial.core.domain.auth.extensions.isValidPassword
import com.yasser.minimasocial.core.model.Login
import com.yasser.minimasocial.core.model.MSUser
import javax.inject.Inject


class LoginUseCase @Inject constructor(
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

        else -> {
            val loginRequest = authRepository.login(
                email = email,
                password = password
            )
            when (loginRequest) {
                is RequestResult.Success<Login> -> {
                    authRepository.saveToken(
                        accessToken = loginRequest.data.accessToken,
                        refreshToken = loginRequest.data.refreshToken
                    )
                    RequestResult.Success(loginRequest.data.user)
                }

                is RequestResult.Error -> loginRequest
            }
        }
    }
}
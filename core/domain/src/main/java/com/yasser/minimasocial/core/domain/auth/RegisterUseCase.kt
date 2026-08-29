package com.yasser.minimasocial.core.domain.auth

import com.yasser.minimasocial.core.common.request_result.RequestError
import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.data.repository.auth.AuthRepository
import com.yasser.minimasocial.core.domain.auth.extensions.isValidEmail
import com.yasser.minimasocial.core.domain.auth.extensions.isValidPassword
import com.yasser.minimasocial.core.model.Register
import javax.inject.Inject


class RegisterUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): RequestResult<Unit> = when {
        !email.isValidEmail() ->
            RequestResult.Error(RequestError.InvalidEmail)

        !password.isValidPassword() ->
            RequestResult.Error(RequestError.InvalidPassword)

        else -> {
            val loginRequest = authRepository.register(
                email = email,
                password = password
            )
            when (loginRequest) {
                is RequestResult.Success<Register> -> {
                    RequestResult.Success(Unit)
                }

                is RequestResult.Error -> loginRequest
            }
        }
    }
}
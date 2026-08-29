package com.yasser.minimasocial.core.domain.auth

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.data.repository.auth.AuthRepository
import com.yasser.minimasocial.core.model.MSUser
import javax.inject.Inject

class RefreshUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): RequestResult<MSUser> {
        return authRepository.refreshUser()
    }
}
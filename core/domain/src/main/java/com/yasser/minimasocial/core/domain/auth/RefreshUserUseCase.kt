package com.yasser.minimasocial.core.domain.auth

import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.data.repository.user.UserRepository
import com.yasser.minimasocial.core.model.user.MSUser
import javax.inject.Inject

class RefreshUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): RequestResult<MSUser> = userRepository
        .refreshUser()
}
package com.yasser.minimasocial.core.domain.post

import com.yasser.minimasocial.core.data.repository.post.PostRepository
import javax.inject.Inject

class GetPostsPagingDataUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

    operator fun invoke() = postRepository.getPostsPagingData()

}
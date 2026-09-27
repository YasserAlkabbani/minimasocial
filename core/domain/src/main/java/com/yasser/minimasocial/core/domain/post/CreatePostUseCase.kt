package com.yasser.minimasocial.core.domain.post

import com.yasser.minimasocial.core.common.request_result.RequestError
import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.data.repository.post.PostRepository
import com.yasser.minimasocial.core.data.repository.user.UserRepository
import com.yasser.minimasocial.core.domain.extensions.isValidPostContent
import com.yasser.minimasocial.core.domain.extensions.isValidPostTitle
import com.yasser.minimasocial.core.model.post.Post
import javax.inject.Inject

class CreatePostUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val postRepository: PostRepository,
) {
    suspend operator fun invoke(
        title: String,
        content: String
    ): RequestResult<Post> = when {
        !title.isValidPostTitle() -> RequestResult.Error(
            RequestError.InvalidTitle
        )

        !content.isValidPostContent() -> RequestResult.Error(
            RequestError.InvalidContent
        )

        else -> userRepository.getCurrentUser().let { user ->
            val createdPost = postRepository.createPost(
                title = title,
                content = content,
                currentUserID = user.id
            )
            RequestResult.Success(createdPost)
        }

    }

}
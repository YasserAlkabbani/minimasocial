package com.yasser.minimasocial.core.domain.post

import com.yasser.minimasocial.core.data.repository.post.PostRepository
import javax.inject.Inject

class GetPostByIDUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

    operator fun invoke(postID: String) = postRepository
        .getPostByID(postID = postID)

}
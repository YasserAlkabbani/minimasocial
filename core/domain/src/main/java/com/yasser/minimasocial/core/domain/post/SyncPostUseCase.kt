package com.yasser.minimasocial.core.domain.post

import com.yasser.minimasocial.core.data.repository.post.PostRepository
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class SyncPostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    operator fun invoke() = postRepository
        .getUnSyncedPosts()
        .onEach { post ->
            postRepository.syncPost(
                postID = post.id,
                title = post.title,
                content = post.content
            )
        }
}
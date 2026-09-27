package com.yasser.minimasocial.feature.post.details.impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yasser.minimasocial.core.common.currentTimeInMilliSec
import com.yasser.minimasocial.core.common.request_result.SyncState
import com.yasser.minimasocial.core.model.post.Post

@Composable
internal fun PostDetailsScreen(
    viewPostViewModel: ViewPostViewModel
) {
    val post by viewPostViewModel.post.collectAsStateWithLifecycle()
    PostDetailsScreen(
        post = post
    )
}

@Composable
fun PostDetailsScreen(
    post: Post?
) {
    post?.let {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = post.title,
                style = MaterialTheme.typography.displayLarge
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = post.content,
                style = MaterialTheme.typography.displayLarge
            )
        }
    }

}


@Preview
@Composable
private fun ViewPostScreenPreview() {
    PostDetailsScreen(
        Post(
            id = "",
            userID = "",
            title = "POST TITLE",
            content = "POST CONTENT",
            createdAt = currentTimeInMilliSec(),
            updatedAt = currentTimeInMilliSec(),
            syncState = SyncState.SYNCED
        )
    )
}
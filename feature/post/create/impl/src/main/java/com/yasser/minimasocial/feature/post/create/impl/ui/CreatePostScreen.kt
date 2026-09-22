@file:OptIn(ExperimentalFoundationStyleApi::class)

package com.yasser.minimasocial.feature.post.create.impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.style.ExperimentalFoundationStyleApi
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.yasser.minimasocial.core.designsystem.component.MSIcon
import com.yasser.minimasocial.core.designsystem.component.MSTextField
import com.yasser.minimasocial.core.designsystem.icon.MSIcons

@Composable
internal fun CreatePostScreen(createPostViewModel: CreatePostViewModel = hiltViewModel()) {
    CreatePostScreen(
        titleTextFieldState = createPostViewModel.postTitleTextFieldState,
        contentTextFieldState = createPostViewModel.postContentTextFieldState,
        createPost = createPostViewModel::createPost
    )
}

@Composable
fun CreatePostScreen(
    titleTextFieldState: TextFieldState,
    contentTextFieldState: TextFieldState,
    createPost: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                content = {
                    MSTextField(
                        titleTextFieldState
                    )
                    MSTextField(
                        contentTextFieldState
                    )
                }
            )
            FloatingActionButton(
                modifier = Modifier.align(alignment = Alignment.BottomEnd),
                onClick = createPost,
                content = {
                    MSIcon(MSIcons.ADD_POST)
                }
            )
        }
    )

}


@Preview
@Composable
private fun CreatePostScreenPreview() {
    CreatePostScreen()
}
package com.yasser.minimasocial.feature.post.create.impl.ui

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.domain.post.CreatePostUseCase
import com.yasser.minimasocial.core.model.post.Post
import com.yasser.minimasocial.core.ui.extentions.asSavableTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val CREATE_POST_TITLE_TEXT_FILED_KEY: String = "CREATE_POST_TITLE_TEXT_FILED_KEY"
private const val CREATE_POST_CONTENT_TEXT_FILED_KEY: String = "CREATE_POST_CONTENT_TEXT_FILED_KEY"

@HiltViewModel
class CreatePostViewModel @Inject constructor(
    private val createPostUseCase: CreatePostUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val postTitleTextFieldState =
        savedStateHandle.asSavableTextFieldState(CREATE_POST_TITLE_TEXT_FILED_KEY)
    val postContentTextFieldState =
        savedStateHandle.asSavableTextFieldState(CREATE_POST_CONTENT_TEXT_FILED_KEY)

    val createPostUIState: StateFlow<CreatePostUIState>
        field = MutableStateFlow<CreatePostUIState>(CreatePostUIState.Idle)

    private fun CreatePostUIState.send() = createPostUIState.update { this }

    val createPostNavigation: StateFlow<CreatePostNavigation>
        field = MutableStateFlow<CreatePostNavigation>(CreatePostNavigation.Idle)

    fun CreatePostNavigation.send() = createPostNavigation.update { this }
    fun doneNavigation() = CreatePostNavigation.Idle.send()

    fun createPost() = viewModelScope.launch {
        CreatePostUIState.Loading.send()
        Log.d("CREATE_POST", "START")
        val requestResult = createPostUseCase(
            title = postTitleTextFieldState.text.toString(),
            content = postContentTextFieldState.text.toString()
        )
        when (requestResult) {
            is RequestResult.Error -> {
                Log.d("CREATE_POST", "ERROR ${requestResult.requestError}")
            }

            is RequestResult.Success<Post> -> {
                Log.d("CREATE_POST", "SUCCESS ${requestResult.data}")
                CreatePostNavigation.NavigateBack.send()
            }
        }
    }

}
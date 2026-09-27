package com.yasser.minimasocial.feature.post.details.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasser.minimasocial.core.domain.post.GetPostByIDUseCase
import com.yasser.minimasocial.core.model.post.Post
import com.yasser.minimasocial.core.ui.extentions.asStateFlow
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel(assistedFactory = ViewPostViewModel.Factory::class)
class ViewPostViewModel @AssistedInject constructor(
    @Assisted val postID: String,
    private val getPostByIDUseCase: GetPostByIDUseCase
) : ViewModel() {

    val post: StateFlow<Post?> = getPostByIDUseCase(postID = postID)
        .asStateFlow(
            initValue = null,
            scope = viewModelScope
        )

    @AssistedFactory
    interface Factory {
        fun create(postID: String): ViewPostViewModel
    }

}



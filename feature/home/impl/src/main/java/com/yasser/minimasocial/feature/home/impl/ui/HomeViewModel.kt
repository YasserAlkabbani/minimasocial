package com.yasser.minimasocial.feature.home.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.yasser.minimasocial.core.domain.post.GetPostsPagingDataUseCase
import com.yasser.minimasocial.core.model.post.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postsPagingDataUseCase: GetPostsPagingDataUseCase
) : ViewModel() {


    val postsPagingData: Flow<PagingData<Post>> = postsPagingDataUseCase()
        .cachedIn(viewModelScope)

    val homeNavigation: StateFlow<HomeNavigation> field = MutableStateFlow<HomeNavigation>(
        HomeNavigation.Idle
    )

    fun HomeNavigation.navigate() = homeNavigation.update { this }
    fun navigateToPostDetails(post: Post) = HomeNavigation.PostDetails(post).navigate()
    fun doneHomeNavigation() = HomeNavigation.Idle.navigate()

    fun refreshPosts() {

    }

}
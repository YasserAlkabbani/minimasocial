package com.yasser.minimasocial.feature.home.impl.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.yasser.minimasocial.core.domain.post.GetPostsPagingDataUseCase
import com.yasser.minimasocial.core.model.post.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postsPagingDataUseCase: GetPostsPagingDataUseCase
) : ViewModel() {


    val postsPagingData: Flow<PagingData<Post>> = postsPagingDataUseCase()
        .cachedIn(viewModelScope)

    fun refreshPosts() {

    }

}
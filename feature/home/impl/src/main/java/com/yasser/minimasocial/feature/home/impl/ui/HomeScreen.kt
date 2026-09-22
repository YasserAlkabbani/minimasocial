package com.yasser.minimasocial.feature.home.impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.yasser.minimasocial.core.designsystem.component.MSText
import com.yasser.minimasocial.core.model.post.Post
import kotlinx.coroutines.flow.Flow

@Composable
internal fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel()) {

    HomeScreen(
        postsPagingData = homeViewModel.postsPagingData
    )
}

@Composable
fun HomeScreen(
    postsPagingData: Flow<PagingData<Post>>
) {

    val postsLazyPagingItems: LazyPagingItems<Post> = postsPagingData.collectAsLazyPagingItems()
    val isEmptyList: Boolean by remember {
        derivedStateOf {
            postsLazyPagingItems.itemCount == 0
        }
    }

    LazyColumn(
        content = {
            items(
                contentType = { "POST" },
                key = { it -> it },
                count = postsLazyPagingItems.itemCount,
                itemContent = { index ->
                    val post: Post? = postsLazyPagingItems.get(index)
                    post?.let {
                        MSText(it.title)
                    }
                }
            )
        }
    )

}


@Preview
@Composable
private fun LoginScreenPreview() {
    HomeScreen()
}
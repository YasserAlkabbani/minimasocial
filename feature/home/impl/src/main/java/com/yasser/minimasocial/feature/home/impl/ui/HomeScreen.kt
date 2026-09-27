package com.yasser.minimasocial.feature.home.impl.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.flow.flowOf

@Composable
internal fun HomeScreen(
    homeViewModel: HomeViewModel,
    navigateToPostDetails: (String) -> Unit
) {

    LaunchedEffect(homeViewModel.homeNavigation) {
        homeViewModel
            .homeNavigation
            .filterNot { it is HomeNavigation.Idle }
            .collect {
                homeViewModel.doneHomeNavigation()
                when (it) {
                    is HomeNavigation.Idle -> Unit
                    is HomeNavigation.PostDetails -> navigateToPostDetails(it.post.id)
                }
            }
    }

    HomeScreen(
        postsPagingData = homeViewModel.postsPagingData,
        navigateToHomeDetails = homeViewModel::navigateToPostDetails
    )
}

@Composable
fun HomeScreen(
    postsPagingData: Flow<PagingData<Post>>,
    navigateToHomeDetails: (Post) -> Unit
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
                key = { post -> post },
                count = postsLazyPagingItems.itemCount,
                itemContent = { index ->
                    postsLazyPagingItems[index]?.let { post ->
                        ListItem(
                            content = { MSText(post.title) },
                            onClick = { navigateToHomeDetails(post) },
                        )
                    }
                }
            )
        }
    )

}


@Preview
@Composable
private fun LoginScreenPreview() {
    HomeScreen(
        flowOf(),
        {}
    )
}
package com.yasser.minimasocial.feature.search.impl.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
internal fun SearchScreen(searchViewModel: SearchViewModel= hiltViewModel()) {
    SearchScreen()
}

@Composable
fun SearchScreen(){

    Text(
        modifier = Modifier.fillMaxSize(),
        text = "SEARCH SCREEN",
        style = MaterialTheme.typography.displayLarge
    )

}


@Preview
@Composable
private fun SearchScreenPreview(){
    SearchScreen()
}
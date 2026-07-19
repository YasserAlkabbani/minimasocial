package com.yasser.minimasocial.feature.post.view.impl.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
internal fun ViewPostScreen(viewPostViewModel: ViewPostViewModel= hiltViewModel()) {
    ViewPostScreen()
}

@Composable
fun ViewPostScreen(){

    Text(
        modifier = Modifier.fillMaxSize(),
        text = "VIEW POST SCREEN",
        style = MaterialTheme.typography.displayLarge
    )

}


@Preview
@Composable
private fun ViewPostScreenPreview(){
    ViewPostScreen()
}
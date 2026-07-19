package com.yasser.minimasocial.feature.post.edit.impl.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
internal fun EditPostScreen(editPostViewModel: EditPostViewModel= hiltViewModel()) {
    EditPostScreen()
}

@Composable
fun EditPostScreen(){

    Text(
        modifier = Modifier.fillMaxSize(),
        text = "EDIT POST SCREEN",
        style = MaterialTheme.typography.displayLarge
    )

}


@Preview
@Composable
private fun EditPostScreenPreview(){
    EditPostScreen()
}
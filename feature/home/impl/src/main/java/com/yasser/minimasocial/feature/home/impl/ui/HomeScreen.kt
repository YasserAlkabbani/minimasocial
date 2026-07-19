package com.yasser.minimasocial.feature.home.impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
internal fun HomeScreen(homeViewModel: HomeViewModel= hiltViewModel()) {
    HomeScreen()
}

@Composable
fun HomeScreen(){

    Column(
        Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.fillMaxSize(),
            text = "HOME SCREEN",
            style = MaterialTheme.typography.displayLarge
        )
    }

}


@Preview
@Composable
private fun LoginScreenPreview(){
    HomeScreen()
}
package com.yasser.minimasocial.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MSScreenPlaceHolder(
    screenName: String,
    goToScreenName: String,
    onGoToScreen: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = screenName,
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onGoToScreen) {
            Text("GO TO $goToScreenName")
        }

    }

}

@Preview
@Composable
private fun MSScreenPlaceHolderPreview() {
    MSScreenPlaceHolder(
        screenName = "TEST SCREEN NAME",
        goToScreenName = "SECOND SCREEN",
        onGoToScreen = {}
    )
}
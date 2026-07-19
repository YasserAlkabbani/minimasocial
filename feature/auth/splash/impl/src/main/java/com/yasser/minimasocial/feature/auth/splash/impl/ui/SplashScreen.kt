package com.yasser.minimasocial.feature.auth.splash.impl.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.yasser.minimasocial.core.ui.MSScreenPlaceHolder

@Composable
internal fun SplashScreen(
    navigateToLogin: () -> Unit,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    SplashScreen(navigateToLogin)
}

@Composable
private fun SplashScreen(navigateToLogin: () -> Unit) {

    MSScreenPlaceHolder(
        screenName = "SPLASH SCREEN",
        goToScreenName = "LOGIN",
        onGoToScreen = navigateToLogin
    )

}


@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen{}
}
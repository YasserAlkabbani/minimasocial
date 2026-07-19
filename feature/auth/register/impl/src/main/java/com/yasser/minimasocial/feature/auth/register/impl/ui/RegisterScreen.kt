package com.yasser.minimasocial.feature.auth.register.impl.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.yasser.minimasocial.core.ui.MSScreenPlaceHolder

@Composable
internal fun RegisterScreen(
    registorViewModel: RegisterViewModel = hiltViewModel(),
    navigateToHome: () -> Unit
) {
    RegisterScreen(navigateToHome)
}

@Composable
private fun RegisterScreen(
    navigateToHome: () -> Unit
) {

    MSScreenPlaceHolder(
        screenName = "REGISTER SCREEN",
        goToScreenName = "HOME",
        onGoToScreen = navigateToHome
    )

}


@Preview
@Composable
private fun SplashScreenPreview() {
    RegisterScreen {}
}
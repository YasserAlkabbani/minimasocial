package com.yasser.minimasocial.feature.auth.login.impl.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.yasser.minimasocial.core.ui.MSScreenPlaceHolder

@Composable
internal fun LoginScreen(
    loginViewModel: LoginViewModel= hiltViewModel(),
    navigateToRegister: () -> Unit
) {
    LoginScreen(navigateToRegister)
}

@Composable
private fun LoginScreen(
    navigateToRegister: () -> Unit
){

    MSScreenPlaceHolder(
        screenName = "LOGIN SCREEN",
        goToScreenName = "REGISTER",
        onGoToScreen = navigateToRegister
    )

}


@Preview
@Composable
private fun LoginScreenPreview(){
    LoginScreen(
        navigateToRegister = {}
    )
}
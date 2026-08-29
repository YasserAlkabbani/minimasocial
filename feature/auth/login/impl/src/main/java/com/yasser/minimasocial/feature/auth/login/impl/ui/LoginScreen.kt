@file:OptIn(ExperimentalFoundationStyleApi::class)

package com.yasser.minimasocial.feature.auth.login.impl.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.style.ExperimentalFoundationStyleApi
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.yasser.minimasocial.core.designsystem.component.MSButton
import com.yasser.minimasocial.core.designsystem.component.MSIcon
import com.yasser.minimasocial.core.designsystem.component.MSText
import com.yasser.minimasocial.core.designsystem.component.MSTextField
import com.yasser.minimasocial.core.designsystem.icon.MSIcons
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNot

@Composable
internal fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navigateToRegister: () -> Unit
) {

    LaunchedEffect(loginViewModel.loginNavigation) {
        loginViewModel.loginNavigation.filterNot { it is LoginNavigation.Idle }
            .collect { loginNavigation ->
                loginViewModel.doneNavigation()
                when (loginNavigation) {
                    LoginNavigation.Idle -> Unit
                    LoginNavigation.Register -> navigateToRegister()
                }
            }
    }

    LoginScreen(
        emailTextFieldState = loginViewModel.emailTextFieldState,
        passwordTextFieldState = loginViewModel.passwordTextFieldState,
        login = loginViewModel::login,
        navigateToRegister = loginViewModel::navigateToRegister
    )

}

@Composable
private fun LoginScreen(
    emailTextFieldState: TextFieldState,
    passwordTextFieldState: TextFieldState,
    login: () -> Unit,
    navigateToRegister: () -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {
        MSIcon(
            imageVector = MSIcons.MINIMA_SOCIAL
        )
        MSText(
            text = "Minima Social"
        )

        MSTextField(
            textFieldState = emailTextFieldState
        )
        MSTextField(
            textFieldState = passwordTextFieldState
        )

        MSButton(
            text = "Login",
            onClick = login
        )
//        MSButton(
//            text = "Register",
//            onClick = navigateToRegister
//        )
    }

}


@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        navigateToRegister = {}
    )
}
@file:OptIn(ExperimentalFoundationStyleApi::class)

package com.yasser.minimasocial.feature.auth.register.impl.ui

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
internal fun RegisterScreen(
    registerViewModel: RegisterViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {

    LaunchedEffect(registerViewModel.loginNavigation) {
        registerViewModel.loginNavigation.filterNot { it is RegisterNavigation.Idle }.collect {
            registerViewModel.doneNavigation()
            when (it) {
                RegisterNavigation.Idle -> Unit
                RegisterNavigation.NavigateBack -> navigateBack()
            }
        }
    }

    RegisterScreen(
        emailTextFieldState = registerViewModel.emailTextFieldState,
        passwordTextFieldState = registerViewModel.passwordTextFieldState,
        navigateBack = registerViewModel::navigateBack,
        register = registerViewModel::register
    )
}

@Composable
private fun RegisterScreen(
    emailTextFieldState: TextFieldState,
    passwordTextFieldState: TextFieldState,
    navigateBack: () -> Unit,
    register: () -> Unit
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
            text = "Register",
            onClick = register
        )
        MSButton(
            text = "Back To Login",
            onClick = navigateBack
        )
    }


}


@Preview
@Composable
private fun SplashScreenPreview() {
    RegisterScreen {}
}
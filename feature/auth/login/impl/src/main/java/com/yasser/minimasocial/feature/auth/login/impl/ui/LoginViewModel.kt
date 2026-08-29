package com.yasser.minimasocial.feature.auth.login.impl.ui

import android.util.Log
import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.domain.auth.LoginUseCase
import com.yasser.minimasocial.core.model.MSUser
import com.yasser.minimasocial.core.ui.extentions.asSavableTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val LOGIN_EMAIL_KEY: String = "LOGIN_EMAIL_KEY"
private const val LOGIN_PASSWORD_KEY: String = "LOGIN_PASSWORD_KEY"

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val emailTextFieldState: TextFieldState =
        savedStateHandle.asSavableTextFieldState(key = LOGIN_EMAIL_KEY)

    val passwordTextFieldState: TextFieldState =
        savedStateHandle.asSavableTextFieldState(key = LOGIN_PASSWORD_KEY)

    val loginUIState: StateFlow<LoginUIState>
        field = MutableStateFlow<LoginUIState>(LoginUIState.Idle)

    private fun LoginUIState.send() = loginUIState.update { this }

    val loginNavigation: StateFlow<LoginNavigation>
        field = MutableStateFlow<LoginNavigation>(LoginNavigation.Idle)

    fun LoginNavigation.navigate() = loginNavigation.update { this }
    fun doneNavigation() = LoginNavigation.Idle.navigate()
    fun navigateToRegister() = LoginNavigation.Register.navigate()


    fun login() = viewModelScope.launch {
        LoginUIState.Loading.send()
        val loginRequest = loginUseCase(
            emailTextFieldState.text.toString(),
            passwordTextFieldState.text.toString()
        )
        when (loginRequest) {
            is RequestResult.Success<MSUser> -> LoginUIState.Success.send()
            is RequestResult.Error -> LoginUIState.Error(loginRequest.requestError).send()
        }
    }

}

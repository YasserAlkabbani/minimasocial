package com.yasser.minimasocial.feature.auth.register.impl.ui

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.domain.auth.RegisterUseCase
import com.yasser.minimasocial.core.ui.extentions.asSavableTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val REGISTER_EMAIL_KEY: String = "REGISTER_EMAIL_KEY"
private const val REGISTER_PASSWORD_KEY: String = "REGISTER_PASSWORD_KEY"


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val emailTextFieldState: TextFieldState =
        savedStateHandle.asSavableTextFieldState(key = REGISTER_EMAIL_KEY)

    val passwordTextFieldState: TextFieldState =
        savedStateHandle.asSavableTextFieldState(key = REGISTER_PASSWORD_KEY)

    val loginUIState: StateFlow<RegisterUIState>
        field = MutableStateFlow<RegisterUIState>(RegisterUIState.Idle)

    private fun RegisterUIState.send() = loginUIState.update { this }

    val loginNavigation: StateFlow<RegisterNavigation>
        field = MutableStateFlow<RegisterNavigation>(RegisterNavigation.Idle)

    fun RegisterNavigation.navigate() = loginNavigation.update { this }
    fun doneNavigation() = RegisterNavigation.Idle.navigate()
    fun navigateBack() = RegisterNavigation.NavigateBack.navigate()


    fun register() = viewModelScope.launch {
        RegisterUIState.Loading.send()
        val loginRequest = registerUseCase(
            emailTextFieldState.text.toString(),
            passwordTextFieldState.text.toString()
        )
        when (loginRequest) {
            is RequestResult.Success<Unit> -> {
                RegisterUIState.Success.send()
                navigateBack()
            }

            is RequestResult.Error -> RegisterUIState.Error(loginRequest.requestError).send()
        }
    }


}
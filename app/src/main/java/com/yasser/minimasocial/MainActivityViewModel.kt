package com.yasser.minimasocial

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.data.repository.auth.AuthRepository
import com.yasser.minimasocial.core.domain.auth.RefreshUserUseCase
import com.yasser.minimasocial.core.model.AuthState
import com.yasser.minimasocial.core.model.MSUser
import com.yasser.minimasocial.core.ui.extentions.asStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    authRepository: AuthRepository,
    private val refreshUserUseCase: RefreshUserUseCase
) : ViewModel() {

    val authState: StateFlow<AuthState> = authRepository.authState()
        .onEach {
            when (it) {
                AuthState.AUTHENTICATED -> refreshUser()
                AuthState.UNAUTHENTICATED -> Unit
            }
        }
        .asStateFlow(
            initValue = AuthState.UNAUTHENTICATED,
            scope = viewModelScope
        )

    fun refreshUser() = viewModelScope.launch {
        val result = refreshUserUseCase()
        Log.d("TEXT_MAIN", "VIEWMODEL REFRESH_USER START")
        when (result) {
            is RequestResult.Error -> {
                Log.d("TEXT_MAIN", "VIEWMODEL REFRESH_USER ERROR ${result.requestError}")
            }

            is RequestResult.Success<MSUser> -> {
                Log.d("TEXT_MAIN", "VIEWMODEL REFRESH_USER START ${result.data}")
            }
        }
    }

}

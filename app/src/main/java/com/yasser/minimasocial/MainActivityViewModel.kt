package com.yasser.minimasocial

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasser.minimasocial.core.common.request_result.RequestResult
import com.yasser.minimasocial.core.data.repository.auth.AuthRepository
import com.yasser.minimasocial.core.domain.auth.RefreshUserUseCase
import com.yasser.minimasocial.core.domain.post.SyncPostUseCase
import com.yasser.minimasocial.core.model.auth.AuthState
import com.yasser.minimasocial.core.model.user.MSUser
import com.yasser.minimasocial.core.ui.extentions.asStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    authRepository: AuthRepository,
    private val refreshUserUseCase: RefreshUserUseCase,
    private val syncPostUseCase: SyncPostUseCase
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

    init {
        syncPosts()
    }

    fun refreshUser() = viewModelScope.launch {
        when (val result = refreshUserUseCase()) {
            is RequestResult.Error -> {}
            is RequestResult.Success<MSUser> -> {}
        }
    }

    fun syncPosts() = viewModelScope.launch {
        authState
            .filter { it == AuthState.AUTHENTICATED }
            .flatMapLatest {
                Log.d("TEST_MAIN", "AUTH_STATE $it")
                syncPostUseCase().onEach { Log.d("TEST_MAIN", "SYNC_POST $it") }
            }.collect()
    }

}

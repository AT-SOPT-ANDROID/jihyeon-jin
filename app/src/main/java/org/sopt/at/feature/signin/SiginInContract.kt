package org.sopt.at.feature.signin

import org.sopt.at.feature.util.UiEffect
import org.sopt.at.feature.util.UiEvent
import org.sopt.at.feature.util.UiState

class SignInContract {
    data class SignInUiState(
        val id: String = "",
        val password: String = "",
        val loginSuccess: Boolean = false,
        val isLoading: Boolean = false
    ) : UiState

    sealed class SignInUiEvent : UiEvent {
        data object LoadAuthInfo : SignInUiEvent()
        data class SaveLoginInfo(val id: String, val password: String) : SignInUiEvent()
    }

    sealed class SignInUiEffect : UiEffect
}
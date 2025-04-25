package org.sopt.at.feature.splash

import org.sopt.at.feature.util.UiEffect
import org.sopt.at.feature.util.UiEvent
import org.sopt.at.feature.util.UiState

class SplashContract {
    data class SplashUiState(
        val isLogin: Boolean = false,
        val isLoading: Boolean = false
    ) : UiState

    sealed class SplashUiEvent : UiEvent {
        data object LoadIsLogin : SplashUiEvent()
    }

    sealed class SplashUiEffect : UiEffect
}
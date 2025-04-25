package org.sopt.at.feature.my

import org.sopt.at.feature.util.UiEffect
import org.sopt.at.feature.util.UiEvent
import org.sopt.at.feature.util.UiState

class MyPageContract {
    data class MyPageUiState(
        val id: String = "",
        val isLoading: Boolean = false
    ) : UiState

    sealed class MyPageUiEvent : UiEvent {
        data object LoadAuthInfo : MyPageUiEvent()
        data object LogOut : MyPageUiEvent()
    }

    sealed class MyPageUiEffect : UiEffect
}
package org.sopt.at.feature.my

import org.sopt.at.feature.util.UiEffect
import org.sopt.at.feature.util.UiEvent
import org.sopt.at.feature.util.UiState

class MyPageContract {
    data class MyPageUiState(
        val userId: Long = -1,
        val nickname: String = "",
        val isLoading: Boolean = false
    ) : UiState

    sealed class MyPageUiEvent : UiEvent {
        data object LoadIdInfo : MyPageUiEvent()
        data object LoadNickname : MyPageUiEvent()
        data object LogOut : MyPageUiEvent()
    }

    sealed class MyPageUiEffect : UiEffect
}
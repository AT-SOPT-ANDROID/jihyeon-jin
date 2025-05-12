package org.sopt.at.feature.my.contract

import org.sopt.at.feature.util.UiEffect
import org.sopt.at.feature.util.UiEvent
import org.sopt.at.feature.util.UiState

class NicknameContract {
    data class NicknameUiState(
        val userId: Long = -1,
        val nickname: String = "",
        val changeSuccess: Boolean = false,
        val errorMessage: String = "",
        val isNicknameValid: Boolean = false
    ) : UiState

    sealed class NicknameUiEvent : UiEvent {
        data object LoadIdInfo : NicknameUiEvent()
        data class PatchNickname(val nickname: String) : NicknameUiEvent()
    }

    sealed class NicknameUiEffect : UiEffect
}
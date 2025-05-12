package org.sopt.at.feature.signup

import org.sopt.at.domain.model.SignUpModel
import org.sopt.at.domain.model.SignUpResultModel
import org.sopt.at.feature.util.UiEffect
import org.sopt.at.feature.util.UiEvent
import org.sopt.at.feature.util.UiState

class SignUpContract {
    data class SignUpUiState(
        val signUpResultModel: SignUpResultModel = SignUpResultModel(
            userId = -1,
            nickname = ""
        ),
        val loginId: String = "",
        val password: String = "",
        val nickname: String = "",
        val signUpSuccess: Boolean = false,
        val errorMessage: String = ""
    ) : UiState

    sealed class SignUpUiEvent : UiEvent {
        data class SignUp(val model: SignUpModel) : SignUpUiEvent()
    }

    sealed class SignUpUiEffect : UiEffect
}

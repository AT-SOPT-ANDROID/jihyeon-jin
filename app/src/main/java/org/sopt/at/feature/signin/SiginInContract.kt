package org.sopt.at.feature.signin

import org.sopt.at.domain.model.SignInModel
import org.sopt.at.domain.model.SignInResultModel
import org.sopt.at.feature.util.UiEffect
import org.sopt.at.feature.util.UiEvent
import org.sopt.at.feature.util.UiState

class SignInContract {
    data class SignInUiState(
        val id: String = "",
        val password: String = "",
        val loginSuccess: Boolean = false,
        val errorMessage: String = "",
        val signInResult: SignInResultModel = SignInResultModel(
            userId = -1
        ),
        val isLoading: Boolean = false
    ) : UiState

    sealed class SignInUiEvent : UiEvent {
        data class SignIn(val signInModel: SignInModel) : SignInUiEvent()
    }

    sealed class SignInUiEffect : UiEffect
}
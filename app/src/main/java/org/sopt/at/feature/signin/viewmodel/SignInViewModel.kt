package org.sopt.at.feature.signin.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.at.core.utils.PreferenceUtil
import org.sopt.at.feature.signin.SignInContract.SignInUiEvent
import org.sopt.at.feature.signin.SignInContract.SignInUiEffect
import org.sopt.at.feature.signin.SignInContract.SignInUiState
import org.sopt.at.feature.util.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val preferenceUtil: PreferenceUtil
) : BaseViewModel<SignInUiState, SignInUiEvent, SignInUiEffect>(SignInUiState()) {
    override fun reduceState(event: SignInUiEvent) {
        when (event) {
            SignInUiEvent.LoadAuthInfo -> loadAuthInfo()
            is SignInUiEvent.SaveLoginInfo -> saveLoginInfo(event.id, event.password)
        }
    }

    private fun loadAuthInfo() {
        updateState(
            currentState.copy(
                isLoading = true
            )
        )
        viewModelScope.launch {
            val id = preferenceUtil.getUserId()
            val password = preferenceUtil.getUserPw()
            updateState(
                currentState.copy(
                    isLoading = false,
                    id = id,
                    password = password
                )
            )
        }
    }
    private fun saveLoginInfo(id: String, password: String) {
        updateState(
            currentState.copy(
                isLoading = true
            )
        )
        viewModelScope.launch {
            updateState(
                currentState.copy(
                    isLoading = false,
                    id = id,
                    password = password,
                    loginSuccess = true
                )
            )
        }
        preferenceUtil.saveLoginState(true)
    }
}
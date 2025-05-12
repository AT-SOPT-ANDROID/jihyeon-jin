package org.sopt.at.feature.signin.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json.Default.decodeFromString
import org.sopt.at.core.utils.PreferenceUtil
import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.domain.model.SignInModel
import org.sopt.at.domain.repository.AuthRepository
import org.sopt.at.feature.signin.SignInContract.SignInUiEvent
import org.sopt.at.feature.signin.SignInContract.SignInUiEffect
import org.sopt.at.feature.signin.SignInContract.SignInUiState
import org.sopt.at.feature.util.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val preferenceUtil: PreferenceUtil,
    private val authRepository: AuthRepository
) : BaseViewModel<SignInUiState, SignInUiEvent, SignInUiEffect>(SignInUiState()) {
    override fun reduceState(event: SignInUiEvent) {
        when (event) {
            is SignInUiEvent.SignIn -> postSignIn(event.signInModel)
        }
    }
    private fun postSignIn(model: SignInModel) {
        viewModelScope.launch {
            authRepository.postSignIn(model).onSuccess { data ->
                updateState(
                    currentState.copy(
                        signInResult = data,
                        loginSuccess = true
                    )
                )
                Log.d("userId", data.userId.toString())
                saveLoginInfo(data.userId)
            }
                .onFailure { error ->
                    val errorMessage = when (error) {
                        is retrofit2.HttpException -> {
                            val errorBody = error.response()?.errorBody()?.string()
                            try {
                                val baseResponse =
                                    decodeFromString<BaseResponse<Unit>>(errorBody ?: "")
                                baseResponse.message
                            } catch (e: Exception) {
                                "에러 응답 파싱 실패: ${e.message}"
                            }
                        }

                        else -> {
                            "알 수 없는 에러가 발생했습니다: ${error.message}"
                        }
                    }
                    updateState(
                        currentState.copy(
                            loginSuccess = false,
                            errorMessage = errorMessage
                        )
                    )
                }
        }
    }
    private fun saveLoginInfo(id: Long) {
        preferenceUtil.saveUserId(id)
        preferenceUtil.saveLoginState(true)
    }
}
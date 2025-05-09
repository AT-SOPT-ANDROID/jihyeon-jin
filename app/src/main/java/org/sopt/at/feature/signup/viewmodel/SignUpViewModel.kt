package org.sopt.at.feature.signup.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json.Default.decodeFromString
import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.domain.model.SignUpModel
import org.sopt.at.domain.repository.AuthRepository
import org.sopt.at.feature.signup.SignUpContract.SignUpUiState
import org.sopt.at.feature.signup.SignUpContract.SignUpUiEvent
import org.sopt.at.feature.signup.SignUpContract.SignUpUiEffect
import org.sopt.at.feature.util.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : BaseViewModel<SignUpUiState, SignUpUiEvent, SignUpUiEffect>(SignUpUiState()) {
    override fun reduceState(event: SignUpUiEvent) {
        when (event) {
            is SignUpUiEvent.SignUp -> postSignUp(event.model)
        }
    }

    private fun postSignUp(signUpModel: SignUpModel) {
        viewModelScope.launch {
            authRepository.postSignUp(signUpModel).onSuccess { data ->
                updateState(
                    currentState.copy(
                        signUpResultModel = data,
                        signUpSuccess = true
                    )
                )
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
                            signUpSuccess = false,
                            errorMessage = errorMessage
                        )
                    )
                }
        }
    }
}
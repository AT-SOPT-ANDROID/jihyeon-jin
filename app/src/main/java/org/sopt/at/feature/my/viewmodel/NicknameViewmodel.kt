package org.sopt.at.feature.my.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json.Default.decodeFromString
import org.sopt.at.core.utils.PreferenceUtil
import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.domain.model.ChangeNicknameModel
import org.sopt.at.domain.model.NicknameModel
import org.sopt.at.domain.repository.UserRepository
import org.sopt.at.feature.my.contract.NicknameContract.NicknameUiEffect
import org.sopt.at.feature.my.contract.NicknameContract.NicknameUiEvent
import org.sopt.at.feature.my.contract.NicknameContract.NicknameUiState
import org.sopt.at.feature.signup.SignUpValidator
import org.sopt.at.feature.util.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class NicknameViewmodel @Inject constructor(
    private val userRepository: UserRepository,
    private val preferenceUtil: PreferenceUtil
) : BaseViewModel<NicknameUiState, NicknameUiEvent, NicknameUiEffect>(NicknameUiState()) {
    override fun reduceState(event: NicknameUiEvent) {
        when (event) {
            is NicknameUiEvent.PatchNickname -> nicknameChange(event.nickname)
            NicknameUiEvent.LoadIdInfo -> loadIdInfo()
        }
    }

    private fun loadIdInfo() {
        viewModelScope.launch {
            val id = preferenceUtil.getUserId()
            Log.d("id", id.toString())
            updateState(
                currentState.copy(
                    userId = id,
                )
            )
        }
    }

    private fun isNicknameValid(nickname: String): Boolean {
        return SignUpValidator.NICKNAME_REGEX.matches(nickname)
    }

    fun updateNickname(nickname: String) {
        updateState(
            currentState.copy(
                nickname = nickname,
            )
        )
    }

    fun clearErrorMessage() {
        updateState(
            currentState.copy(
                errorMessage = "",
            )
        )
    }

    private fun nicknameChange(nickname: String) {
        if (isNicknameValid(nickname)) {
            updateState(
                currentState.copy(
                    isNicknameValid = true,
                )
            )
            patchNickname(nickname)
        } else {
            updateState(
                currentState.copy(
                    isNicknameValid = false,
                    changeSuccess = false,
                    errorMessage = "닉네임이 형식에 맞지 않습니다."
                )
            )
        }
    }

    private fun patchNickname(nickname: String) {
        viewModelScope.launch {
            userRepository.patchNickname(
                ChangeNicknameModel(
                    userId = currentState.userId,
                    nickname = NicknameModel(nickname)
                )
            )
                .onSuccess {
                    updateState(
                        currentState.copy(
                            changeSuccess = true,
                            errorMessage = ""
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
                            changeSuccess = false,
                            errorMessage = errorMessage
                        )
                    )
                }
        }
    }
}
package org.sopt.at.feature.my.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json.Default.decodeFromString
import org.sopt.at.data.dto.base.BaseResponse
import org.sopt.at.domain.repository.UserRepository
import org.sopt.at.feature.my.contract.NicknameContract.NicknameUiEffect
import org.sopt.at.feature.my.contract.NicknameContract.NicknameUiEvent
import org.sopt.at.feature.my.contract.NicknameContract.NicknameUiState
import org.sopt.at.feature.util.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class NicknameViewmodel @Inject constructor(
    private val userRepository: UserRepository,
) : BaseViewModel<NicknameUiState, NicknameUiEvent, NicknameUiEffect>(NicknameUiState()) {
    override fun reduceState(event: NicknameUiEvent) {
        when (event) {
            is NicknameUiEvent.PatchNickname -> patchNickname(event.nickname)
        }
    }
    fun updateNickname(nickname: String) {
        updateState(currentState.copy(nickname = nickname))
    }

    private fun patchNickname(nickname: String) {
        viewModelScope.launch {

        }
    }
}

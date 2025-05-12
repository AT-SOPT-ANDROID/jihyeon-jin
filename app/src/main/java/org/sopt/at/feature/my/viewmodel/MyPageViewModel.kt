package org.sopt.at.feature.my.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.at.core.utils.PreferenceUtil
import org.sopt.at.domain.model.MyNicknameModel
import org.sopt.at.domain.repository.UserRepository
import org.sopt.at.feature.my.contract.MyPageContract.MyPageUiEffect
import org.sopt.at.feature.my.contract.MyPageContract.MyPageUiEvent
import org.sopt.at.feature.my.contract.MyPageContract.MyPageUiState
import org.sopt.at.feature.util.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val preferenceUtil: PreferenceUtil,
    private val userRepository: UserRepository
) : BaseViewModel<MyPageUiState, MyPageUiEvent, MyPageUiEffect>(MyPageUiState()) {
    override fun reduceState(event: MyPageUiEvent) {
        when (event) {
            MyPageUiEvent.LoadIdInfo -> loadIdInfo()
            MyPageUiEvent.LogOut -> logOut()
            MyPageUiEvent.LoadNickname -> getMyNickname(
                MyNicknameModel(
                    userId = currentState.userId
                )
            )
        }
    }

    private fun loadIdInfo() {
        updateState(
            currentState.copy(
                isLoading = true
            )
        )
        viewModelScope.launch {
            val id = preferenceUtil.getUserId()
            Log.d("id", id.toString())
            updateState(
                currentState.copy(
                    isLoading = false,
                    userId = id,
                )
            )
        }
    }

    private fun getMyNickname(model: MyNicknameModel) {
        updateState(
            currentState.copy(
                isLoading = true
            )
        )
        viewModelScope.launch {
            userRepository.getMyNickname(model).onSuccess { data ->
                updateState(
                    currentState.copy(
                        nickname = data.nickname,
                        isLoading = false
                    )
                )
            }
        }
    }

    private fun logOut() {
        preferenceUtil.clearAllData()
    }
}
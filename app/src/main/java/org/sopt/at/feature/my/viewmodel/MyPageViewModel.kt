package org.sopt.at.feature.my.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.at.core.utils.PreferenceUtil
import org.sopt.at.feature.my.MyPageContract.MyPageUiEvent
import org.sopt.at.feature.my.MyPageContract.MyPageUiState
import org.sopt.at.feature.my.MyPageContract.MyPageUiEffect
import org.sopt.at.feature.util.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val preferenceUtil: PreferenceUtil
) : BaseViewModel<MyPageUiState, MyPageUiEvent, MyPageUiEffect>(MyPageUiState()) {
    override fun reduceState(event: MyPageUiEvent) {
        when (event) {
            MyPageUiEvent.LoadAuthInfo -> loadIdInfo()
            MyPageUiEvent.LogOut -> logOut()
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
            updateState(
                currentState.copy(
                    isLoading = false,
                    id = id
                )
            )
        }
    }
    private fun logOut() {
        preferenceUtil.clearAllData()
    }
}
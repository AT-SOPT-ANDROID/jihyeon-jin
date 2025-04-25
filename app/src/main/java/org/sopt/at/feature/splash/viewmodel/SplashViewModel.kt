package org.sopt.at.feature.splash.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.at.core.utils.PreferenceUtil
import org.sopt.at.feature.splash.SplashContract.SplashUiEvent
import org.sopt.at.feature.splash.SplashContract.SplashUiState
import org.sopt.at.feature.splash.SplashContract.SplashUiEffect
import org.sopt.at.feature.util.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val preferenceUtil: PreferenceUtil
) : BaseViewModel<SplashUiState, SplashUiEvent, SplashUiEffect>(SplashUiState()) {
    override fun reduceState(event: SplashUiEvent) {
        when (event) {
            SplashUiEvent.LoadIsLogin -> loadIsLogin()
        }
    }

    private fun loadIsLogin() {
        updateState(
            currentState.copy(
                isLoading = true
            )
        )
        viewModelScope.launch {
            val isLogin = preferenceUtil.getLoginState()
            updateState(
                currentState.copy(
                    isLoading = false,
                    isLogin = isLogin
                )
            )
        }
    }
}
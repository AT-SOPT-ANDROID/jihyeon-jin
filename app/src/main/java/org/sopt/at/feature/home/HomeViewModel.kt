package org.sopt.at.feature.home

import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.at.domain.repository.DummyHomeProgramRepository
import org.sopt.at.feature.util.BaseViewModel
import javax.inject.Inject
import org.sopt.at.feature.home.HomeContract.HomeUiEffect
import org.sopt.at.feature.home.HomeContract.HomeUiEvent
import org.sopt.at.feature.home.HomeContract.HomeUiState

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dummyHomeProgramRepository: DummyHomeProgramRepository
) : BaseViewModel<HomeUiState, HomeUiEvent, HomeUiEffect>(HomeUiState()) {

    override fun reduceState(event: HomeUiEvent) {
        when (event) {
            is HomeUiEvent.SetContentType -> {
                updateState(
                    currentState.copy(
                        selectedContentType = event.contentType
                    )
                )
            }
        }
    }

    fun getDummyHomeContent() = updateState(
        currentState.copy(
            mainPrograms = dummyHomeProgramRepository.getBannerItems(),
            commonPrograms = dummyHomeProgramRepository.getNowItems(),
            rankingPrograms = dummyHomeProgramRepository.getTop20Items()
        )
    )
}
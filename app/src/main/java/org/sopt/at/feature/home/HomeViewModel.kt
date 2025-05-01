package org.sopt.at.feature.home

import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.at.domain.model.ContentCategory
import org.sopt.at.domain.model.Program
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

    init {
        sendEvent(HomeUiEvent.GetDummyHomeContent)
    }

    override fun reduceState(event: HomeUiEvent) {
        when (event) {
            is HomeUiEvent.SetContentCategory -> setContentType(event.contentCategory)
            HomeUiEvent.GetDummyHomeContent -> getDummyHomeContent()
        }
    }

    private fun getDummyHomeContent() {
        val main = dummyHomeProgramRepository.getBannerItems()
        val common = dummyHomeProgramRepository.getNowItems()
        val ranking = dummyHomeProgramRepository.getTop20Items()

        updateState(
            currentState.copy(
                mainPrograms = main,
                commonPrograms = common,
                rankingPrograms = ranking,
                filteredMainPrograms = main,
                filteredCommonPrograms = common,
                filteredRankingPrograms = ranking
            )
        )
    }

    private fun List<Program>.filterBy(contentCategory: ContentCategory): List<Program> {
        return if (contentCategory == ContentCategory.ALL) this
        else filter { it.type == contentCategory }
    }

    private fun setContentType(contentCategory: ContentCategory) {
        updateState(
            currentState.copy(
                filteredMainPrograms = currentState.mainPrograms.copy(
                    programList = currentState.mainPrograms.programList.filterBy(contentCategory)
                ),
                filteredCommonPrograms = currentState.commonPrograms.copy(
                    programList = currentState.commonPrograms.programList.filterBy(contentCategory)
                ),
                filteredRankingPrograms = currentState.rankingPrograms.copy(
                    programList = currentState.rankingPrograms.programList.filterBy(contentCategory)
                ),
                selectedContentCategory = contentCategory
            )
        )
    }
}
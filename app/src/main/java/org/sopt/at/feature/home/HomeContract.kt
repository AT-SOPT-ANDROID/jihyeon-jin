package org.sopt.at.feature.home

import org.sopt.at.core.type.ContentType
import org.sopt.at.domain.model.HomeRecommendation
import org.sopt.at.feature.util.UiEffect
import org.sopt.at.feature.util.UiEvent
import org.sopt.at.feature.util.UiState

class HomeContract {
    data class HomeUiState(
        val mainPrograms: HomeRecommendation = HomeRecommendation(
            title = "",
            programList = listOf()
        ),

        val commonPrograms: HomeRecommendation = HomeRecommendation(
            title = "지금 방영 중인 콘텐츠",
            programList = emptyList()
        ),

        val rankingPrograms: HomeRecommendation = HomeRecommendation(
            title = "오늘의 티빙 TOP 20",
            programList = emptyList()
        ),
        val selectedContentType: ContentType? = null
    ) : UiState

    sealed class HomeUiEvent : UiEvent {
        data class SetContentType(val contentType: ContentType) : HomeUiEvent()
    }

    sealed class HomeUiEffect : UiEffect
}
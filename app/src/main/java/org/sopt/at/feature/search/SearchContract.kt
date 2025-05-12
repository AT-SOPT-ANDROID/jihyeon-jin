package org.sopt.at.feature.search

import org.sopt.at.domain.model.SearchUserResultModel
import org.sopt.at.feature.util.UiEffect
import org.sopt.at.feature.util.UiEvent
import org.sopt.at.feature.util.UiState

class SearchContract {
    data class SearchUiState(
        val keyword: String = "",
        val searchSuccess: Boolean = false,
        val errorMessage: String = "",
        val searchResult: SearchUserResultModel = SearchUserResultModel(
            nicknameList = emptyList()
        )
    ) : UiState

    sealed class SearchUiEvent : UiEvent {
        data class Search(val keyword: String) : SearchUiEvent()
    }

    sealed class SearchUiEffect : UiEffect
}
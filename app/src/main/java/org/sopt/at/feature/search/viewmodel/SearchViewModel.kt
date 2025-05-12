package org.sopt.at.feature.search.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.at.domain.repository.UserRepository
import org.sopt.at.feature.search.SearchContract.SearchUiEffect
import org.sopt.at.feature.search.SearchContract.SearchUiEvent
import org.sopt.at.feature.search.SearchContract.SearchUiState
import org.sopt.at.feature.util.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val authRepository: UserRepository
) : BaseViewModel<SearchUiState, SearchUiEvent, SearchUiEffect>(SearchUiState()) {
    override fun reduceState(event: SearchUiEvent) {
        when (event) {
            is SearchUiEvent.Search -> getUserList(event.keyword)
        }
    }

    private fun getUserList(searchUserModel: String) {
        viewModelScope.launch {
            authRepository.getUserList(searchUserModel).onSuccess { data ->
                updateState(
                    currentState.copy(
                        searchResult = data,
                        searchSuccess = true
                    )
                )
            }
                .onFailure {
                    updateState(
                        currentState.copy(
                            searchSuccess = false,
                            errorMessage = it.message ?: "에러 발생"
                        )
                    )
                }
        }
    }
}
package org.sopt.at.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.core.component.SearchTextField
import org.sopt.at.feature.search.viewmodel.SearchViewModel
import org.sopt.at.ui.theme.TivingTheme.colors
import org.sopt.at.ui.theme.TivingTheme.typography

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    SearchScreen(
        state = state,
        onSearchButtonClick = { keyword ->
            viewModel.sendEvent(SearchContract.SearchUiEvent.Search(keyword))
        },
        modifier = modifier
    )
}
@Composable
private fun SearchScreen(
    state: SearchContract.SearchUiState,
    onSearchButtonClick : (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var keyword by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize().background(colors.basicBlack)) {
        SearchTextField(
            modifier =
                Modifier.fillMaxWidth().padding(8.dp),
            text = keyword,
            onValueChange = { keyword = it },
            onButtonClick = { onSearchButtonClick(keyword) },
        )

        SearchContent(
            state = state,
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Composable
private fun SearchContent(
    state: SearchContract.SearchUiState,
    modifier: Modifier = Modifier,
) {
    if(state.searchSuccess) {
        if(state.searchResult.nicknameList.isNotEmpty()) {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(state.searchResult.nicknameList) { user ->
                    Text(
                        text = user,
                        style = typography.body.merge(colors.basicWhite)
                    )
                }
            }
        }
        else {
            Column(modifier = modifier) {
                Text(
                    modifier = Modifier.fillMaxSize()
                        .align(Alignment.CenterHorizontally),
                    text = "검색 결과가 없습니다.",
                    textAlign = TextAlign.Center,
                    style = typography.body.merge(colors.basicWhite)
                )
            }
        }
    }
}
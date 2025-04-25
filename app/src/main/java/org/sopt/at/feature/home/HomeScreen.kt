package org.sopt.at.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.core.type.ContentType
import org.sopt.at.feature.home.component.BannerPager
import org.sopt.at.feature.home.component.CommonProgramHorizontalColumn
import org.sopt.at.feature.home.component.ContentTypeRow
import org.sopt.at.feature.home.component.HomeTopBar
import org.sopt.at.feature.home.component.RankingProgramHorizontalColumn
import org.sopt.at.ui.theme.Black

@Composable
fun HomeRoute(
    padding: PaddingValues,
    onNavigateToMyPage: () -> Unit,
    onContentTypeSelected: (ContentType) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeScreen(
        padding = padding,
        onNavigateToMyPage = onNavigateToMyPage,
        onContentTypeSelected = onContentTypeSelected,
        viewModel = viewModel
    )
}

@Composable
fun HomeScreen(
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    onNavigateToMyPage: () -> Unit,
    onContentTypeSelected: (ContentType) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getDummyHomeContent()
    }

    LazyColumn(
        modifier = modifier.padding(padding),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HomeTopBar(
                onLiveButtonClick = {
                    // TODO: 무선 연결 안내
                },
                onProfileButtonClick = {
                    onNavigateToMyPage()
                }
            )
        }
        stickyHeader {
            ContentTypeRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Black)
                    .padding(8.dp),
                onContentTypeSelected = { contentType ->
                    onContentTypeSelected(contentType)
                    viewModel.sendEvent(
                        HomeContract.HomeUiEvent.SetContentType(contentType)
                    )
                },
                selectedContentType = homeState.selectedContentType
            )
        }

        item {
            BannerPager(
                programList = homeState.mainPrograms.programList,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
            )
        }

        item {
            CommonProgramHorizontalColumn(
                program = homeState.commonPrograms,
                onContentClicked = { }
            )
        }

        item {
            RankingProgramHorizontalColumn(
                modifier = Modifier.fillMaxWidth(),
                programLists = homeState.rankingPrograms,
                onContentClicked = { }
            )
        }
    }
}
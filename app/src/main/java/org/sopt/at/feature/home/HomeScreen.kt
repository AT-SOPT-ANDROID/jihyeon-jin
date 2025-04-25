package org.sopt.at.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
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
    onNavigateToMyPage: () -> Unit,
    onContentTypeSelected: (ContentType) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    HomeScreen(
        onNavigateToMyPage = onNavigateToMyPage,
        onContentTypeSelected = onContentTypeSelected,
        modifier = modifier,
        viewModel = viewModel
    )
}

@Composable
fun HomeScreen(
    onNavigateToMyPage: () -> Unit,
    onContentTypeSelected: (ContentType) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getDummyHomeContent()
    }

    LazyColumn(
        modifier = modifier
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
                    .padding(16.dp),
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
            Spacer(Modifier.height(16.dp))
        }

        item {
            CommonProgramHorizontalColumn(
                program = homeState.commonPrograms,
                onContentClicked = { }
            )
            Spacer(Modifier.height(16.dp))
        }

        item {
            RankingProgramHorizontalColumn(
                modifier = Modifier.fillMaxWidth(),
                programLists = homeState.rankingPrograms,
                onContentClicked = { }
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}
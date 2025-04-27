package org.sopt.at.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.domain.model.ContentCategory
import org.sopt.at.feature.home.HomeContract.HomeUiEvent
import org.sopt.at.feature.home.HomeContract.HomeUiState
import org.sopt.at.feature.home.component.BannerPager
import org.sopt.at.feature.home.component.CommonProgramHorizontalColumn
import org.sopt.at.feature.home.component.ContentCategoryRow
import org.sopt.at.feature.home.component.HomeTopBar
import org.sopt.at.feature.home.component.RankingProgramHorizontalColumn
import org.sopt.at.ui.theme.Black

@Composable
fun HomeRoute(
    onNavigateToMyPage: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val homeState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        onNavigateToMyPage = onNavigateToMyPage,
        modifier = modifier,
        homeState = homeState,
        onCategorySelected = { contentCategory ->
            viewModel.sendEvent(HomeUiEvent.SetContentCategory(contentCategory))
        }
    )
}

@Composable
private fun HomeScreen(
    onNavigateToMyPage: () -> Unit,
    modifier: Modifier = Modifier,
    homeState: HomeUiState,
    onCategorySelected: (ContentCategory) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            HomeTopBar(
                onLogoClick = {
                    onCategorySelected(ContentCategory.ALL)
                },
                onLiveButtonClick = {
                    // TODO: 무선 연결 안내
                },
                onProfileButtonClick = {
                    onNavigateToMyPage()
                }
            )
        }
        stickyHeader {
            ContentCategoryRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Black)
                    .padding(16.dp),
                onContentCategorySelected = { contentCategory ->
                    onCategorySelected(contentCategory)
                },
                selectedContentCategory = homeState.selectedContentCategory
            )
        }

        item {
            if(homeState.filteredMainPrograms.programList.isNotEmpty()) {
                BannerPager(
                    programList = homeState.filteredMainPrograms.programList,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(450.dp)
                )
                Spacer(Modifier.height(16.dp))
            }
        }

        item {
            CommonProgramHorizontalColumn(
                program = homeState.filteredCommonPrograms,
                onContentClicked = { }
            )
            Spacer(Modifier.height(16.dp))
        }

        item {
            RankingProgramHorizontalColumn(
                modifier = Modifier.fillMaxWidth(),
                programLists = homeState.filteredRankingPrograms,
                onContentClicked = { }
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}
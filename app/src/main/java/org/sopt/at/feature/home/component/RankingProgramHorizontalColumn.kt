package org.sopt.at.feature.home.component

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import org.sopt.at.R
import org.sopt.at.domain.model.HomeRecommendation
import org.sopt.at.domain.model.Program
import org.sopt.at.feature.home.component.item.RankingProgramItem
import org.sopt.at.ui.theme.TivingTheme.colors
import org.sopt.at.ui.theme.TivingTheme.typography

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun RankingProgramHorizontalColumn (
    programLists: HomeRecommendation,
    onContentClicked: (Program) -> Unit,
    modifier: Modifier = Modifier,
) {
    val lazyListState = rememberLazyListState()
    val rankResource : List<Int> = listOf(
        R.drawable.img_rank_1,
        R.drawable.img_rank_2,
        R.drawable.img_rank_3,
        R.drawable.img_rank_4,
        R.drawable.img_rank_5,
        R.drawable.img_rank_6,
        R.drawable.img_rank_7,
        R.drawable.img_rank_8,
        R.drawable.img_rank_9,
        R.drawable.img_rank_10,
        R.drawable.img_rank_11,
        R.drawable.img_rank_12,
        R.drawable.img_rank_13,
        R.drawable.img_rank_14,
        R.drawable.img_rank_15,
        R.drawable.img_rank_16,
        R.drawable.img_rank_17,
        R.drawable.img_rank_18,
        R.drawable.img_rank_19,
        R.drawable.img_rank_20
    )
    Column(
        modifier = modifier
    ) {
        Text(
            text = programLists.title,
            style = typography.subTitle.merge(colors.basicWhite),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        LazyRow(
            modifier = Modifier.padding(top = 10.dp),
            state = lazyListState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            flingBehavior = rememberSnapFlingBehavior(
                lazyListState = lazyListState,
                snapPosition = SnapPosition.Start
            )
        ) {
            itemsIndexed(programLists.programList) { index, item ->
                RankingProgramItem(
                    modifier = Modifier.width((LocalConfiguration.current.screenWidthDp.dp / 2) - 28.dp),
                    program = item,
                    rank = rankResource[index],
                    onItemClick = onContentClicked
                )
            }
        }
    }
}
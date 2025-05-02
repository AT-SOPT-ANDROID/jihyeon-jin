package org.sopt.at.feature.home.component

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import org.sopt.at.domain.model.HomeRecommendation
import org.sopt.at.domain.model.Program
import org.sopt.at.feature.home.component.item.CommonProgramItem
import org.sopt.at.ui.theme.TivingTheme.colors
import org.sopt.at.ui.theme.TivingTheme.typography

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun CommonProgramHorizontalColumn(
    program: HomeRecommendation,
    onContentClicked: (Program) -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberLazyListState()

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = program.title,
                style = typography.subTitle.merge(colors.basicWhite),
            )
            Spacer(modifier = Modifier.weight(1f))
        }
        LazyRow(
            modifier = Modifier.padding(top = 8.dp),
            state = state,
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            flingBehavior = rememberSnapFlingBehavior(lazyListState = state)
        ) {
            items(program.programList.size) { item ->
                CommonProgramItem(
                    modifier = Modifier
                        .width((LocalConfiguration.current.screenWidthDp.dp / 3) - 16.dp)
                        .padding(horizontal = 3.dp),
                    program = program.programList[item],
                    onClick = onContentClicked
                )
            }
        }
    }
}
package org.sopt.at.feature.home.component

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.sopt.at.R
import org.sopt.at.domain.model.Program

@Composable
fun BannerPager(
    programList: List<Program>,
    modifier: Modifier = Modifier
) {
    val coroutine = rememberCoroutineScope()

    val pagerState = rememberPagerState(
        initialPage = Int.MAX_VALUE / 2,
        pageCount = { Int.MAX_VALUE }
    )

    LaunchedEffect(true) {
        while (true) {
            delay(3000)
            coroutine.launch {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            }
        }
    }

    HorizontalPager(
    state = pagerState,
    beyondViewportPageCount = 1,
    modifier = modifier.height(450.dp),
    contentPadding = PaddingValues(horizontal = 24.dp),
    pageSpacing = 12.dp
    ) { page ->
        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            if (programList.isNotEmpty()) {
                Image(
                    painter = painterResource(programList[page % programList.size].imgRes),
                    contentDescription = programList[page % programList.size].title,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.BottomCenter
                )
            }
        }
    }
    AutoScrollEffect(pagerState)
}

@Composable
fun AutoScrollEffect(pagerState: PagerState) {
    LaunchedEffect(pagerState.currentPage) {
        while (true) {
            delay(3000)
            withContext(NonCancellable) {
                pagerState.animateScrollToPage(
                    page = pagerState.currentPage + 1,
                    animationSpec = spring(stiffness = Spring.StiffnessLow)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BannerPagerPreview() {
    BannerPager(
        programList = listOf(
            Program("", R.drawable.img_program_shin_byeong),
            Program("", R.drawable.img_program_camp),
            Program("", R.drawable.img_program_bunny),
            Program("", R.drawable.img_program_ehon),
            Program("", R.drawable.img_program_im_solo)
        )
    )
}
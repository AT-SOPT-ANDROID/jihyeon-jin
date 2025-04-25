package org.sopt.at.feature.home.component.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.at.core.extension.noRippleClickable
import org.sopt.at.domain.model.Program

@Composable
fun RankingProgramItem(
    program: Program,
    rank: Int,
    modifier: Modifier = Modifier,
    onItemClick: (Program) -> Unit = {}
) {
    Row(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(rank),
            contentDescription = program.title,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(50.dp)
                .align(Alignment.Bottom)
        )
        Image(
            painter = painterResource(program.imgRes),
            contentDescription = program.title,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(174.dp)
                .clip(
                    shape = RoundedCornerShape(12.dp)
                )
                .noRippleClickable { onItemClick(program) },
        )
    }
}
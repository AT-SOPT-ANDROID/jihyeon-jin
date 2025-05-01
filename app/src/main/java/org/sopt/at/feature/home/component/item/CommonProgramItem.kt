package org.sopt.at.feature.home.component.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.at.core.extension.noRippleClickable
import org.sopt.at.domain.model.Program

@Composable
fun CommonProgramItem(
    program: Program,
    modifier: Modifier = Modifier,
    onClick: (Program) -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(12.dp)
            )
            .noRippleClickable { onClick(program) }
    ) {
        Image(
            painter = painterResource(program.imgRes),
            contentDescription = program.title,
            modifier = Modifier
                .fillMaxSize()
                .height(174.dp),
            contentScale = ContentScale.Crop
        )
    }
}
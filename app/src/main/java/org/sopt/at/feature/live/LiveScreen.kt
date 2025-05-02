package org.sopt.at.feature.live

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.at.ui.theme.TivingTheme.colors

@Composable
fun LiveRoute(
    modifier: Modifier = Modifier
) {
    LiveScreen(
       modifier = modifier
    )
}
@Composable
fun LiveScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(colors.basicBlack)
    ) {

    }
}
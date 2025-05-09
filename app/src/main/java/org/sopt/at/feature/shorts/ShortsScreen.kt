package org.sopt.at.feature.shorts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.at.ui.theme.TivingTheme.colors

@Composable
fun ShortsRoute(
    modifier: Modifier = Modifier
) {
    ShortsScreen(
        modifier = modifier
    )
}
@Composable
private fun ShortsScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(colors.basicBlack)
    ) { }
}
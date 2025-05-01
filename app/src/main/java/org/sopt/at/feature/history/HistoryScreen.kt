package org.sopt.at.feature.history

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.at.ui.theme.Black

@Composable
fun HistoryRoute(
    modifier: Modifier = Modifier
) {
    HistoryScreen(
        modifier = modifier
    )
}
@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Black)
    ) {

    }
}
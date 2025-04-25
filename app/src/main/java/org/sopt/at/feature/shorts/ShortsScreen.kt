package org.sopt.at.feature.shorts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.at.ui.theme.Black

@Composable
fun ShortsRoute(
    padding: PaddingValues
) {
    ShortsScreen(
        padding = padding
    )
}
@Composable
fun ShortsScreen(
    padding: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .background(Black)
    ) {

    }
}
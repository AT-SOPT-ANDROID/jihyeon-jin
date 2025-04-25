package org.sopt.at.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.at.ui.theme.Black

@Composable
fun SearchRoute(
    padding: PaddingValues
) {
    SearchScreen(
        padding = padding
    )
}
@Composable
fun SearchScreen(
    padding: PaddingValues
) {
    Column(
        modifier = Modifier
            .padding(padding)
            .background(Black)
    ) {

    }
}
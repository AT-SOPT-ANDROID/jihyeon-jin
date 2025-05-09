package org.sopt.at.feature.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.at.ui.theme.TivingTheme.colors
@Composable
fun SearchRoute(
    modifier: Modifier = Modifier
) {
    SearchScreen(
        modifier = modifier
    )
}
@Composable
private fun SearchScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(colors.basicBlack)
    ) {

    }
}
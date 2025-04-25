package org.sopt.at.feature.history.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.feature.history.HistoryRoute

fun NavController.navigateToHistory(navOptions: NavOptions) {
    navigate(MainTabRoute.History, navOptions)
}
fun NavGraphBuilder.historyNavGraph(
    modifier: Modifier = Modifier
) {
    composable<MainTabRoute.History> {
        HistoryRoute(
            modifier = modifier
        )
    }
}
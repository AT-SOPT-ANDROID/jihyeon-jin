package org.sopt.at.feature.history.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.feature.history.HistoryScreen

fun NavController.navigateToHistory(navOptions: NavOptions) {
    navigate(MainTabRoute.History, navOptions)
}
fun NavGraphBuilder.historyNavGraph(
    padding: PaddingValues
) {
    composable<MainTabRoute.History> {
        HistoryScreen(
            padding = padding
        )
    }
}
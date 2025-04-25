package org.sopt.at.feature.shorts.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.feature.shorts.ShortsRoute

fun NavController.navigateToShorts(navOptions: NavOptions) {
    navigate(MainTabRoute.Shorts, navOptions)
}
fun NavGraphBuilder.shortsNavGraph(
    modifier: Modifier = Modifier
) {
    composable<MainTabRoute.Shorts> {
        ShortsRoute(
            modifier = modifier
        )
    }
}
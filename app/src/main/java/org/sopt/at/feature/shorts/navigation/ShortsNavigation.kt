package org.sopt.at.feature.shorts.navigation

import androidx.compose.foundation.layout.PaddingValues
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
    padding: PaddingValues
) {
    composable<MainTabRoute.Shorts> {
        ShortsRoute(
            padding = padding
        )
    }
}
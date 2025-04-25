package org.sopt.at.feature.live.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.feature.live.LiveRoute

fun NavController.navigateToLive(navOptions: NavOptions) {
    navigate(MainTabRoute.Live, navOptions)
}
fun NavGraphBuilder.liveNavGraph(
    padding: PaddingValues
) {
    composable<MainTabRoute.Live> {
        LiveRoute(
            padding = padding
        )
    }
}
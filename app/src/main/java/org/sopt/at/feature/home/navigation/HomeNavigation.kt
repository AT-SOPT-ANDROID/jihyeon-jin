package org.sopt.at.feature.home.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.feature.home.HomeRoute

fun NavController.navigateToHome(navOptions: NavOptions) {
    navigate(MainTabRoute.Home, navOptions)
}
fun NavGraphBuilder.homeNavGraph(
    onNavigateToMyPage: () -> Unit,
    modifier: Modifier = Modifier
) {
    composable<MainTabRoute.Home> {
        HomeRoute(
            onNavigateToMyPage = onNavigateToMyPage,
            modifier = modifier
        )
    }
}
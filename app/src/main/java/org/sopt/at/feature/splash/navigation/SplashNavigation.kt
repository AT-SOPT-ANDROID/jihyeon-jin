package org.sopt.at.feature.splash.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.splash.SplashRoute

fun NavGraphBuilder.splashNavGraph(
    onNavigateToHome: () -> Unit,
    onNavigateToSignIn: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    composable<Route.Splash> {
        SplashRoute(
            onNavigateToHome = onNavigateToHome,
            onNavigateToSignIn = onNavigateToSignIn,
            modifier = modifier
        )
    }
}
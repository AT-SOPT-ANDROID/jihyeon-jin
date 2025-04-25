package org.sopt.at.feature.splash.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.splash.SplashRoute

fun NavGraphBuilder.splashNavGraph(
    onNavigateToHome: () -> Unit,
    onNavigateToSignIn: (String, String) -> Unit,
    padding: PaddingValues,
) {
    composable<Route.Splash> {
        SplashRoute(
            padding = padding,
            onNavigateToHome = onNavigateToHome,
            onNavigateToSignIn = onNavigateToSignIn
        )
    }
}
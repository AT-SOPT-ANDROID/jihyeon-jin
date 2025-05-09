package org.sopt.at.feature.signin.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.signin.SignInRoute

fun NavController.navigateToSignIn() {
    navigate(Route.SignIn)
}
fun NavGraphBuilder.signInNavGraph(
    onNavigateToHome: () -> Unit,
    onNavigateToSignUp: () -> Unit,
    popBackStack: () -> Unit ,
    modifier: Modifier = Modifier
) {
    composable<Route.SignIn> {
        SignInRoute(
            onNavigateToHome = onNavigateToHome,
            onNavigateToSignUp = onNavigateToSignUp,
            popBackStack = popBackStack,
            modifier = modifier
        )
    }
}
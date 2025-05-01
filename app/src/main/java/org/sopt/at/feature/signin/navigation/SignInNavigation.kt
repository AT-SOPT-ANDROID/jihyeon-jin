package org.sopt.at.feature.signin.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.signin.SignInRoute

fun NavController.navigateToSignIn(email: String, password: String) {
    navigate(Route.SignIn(email,password))
}
fun NavGraphBuilder.signInNavGraph(
    onNavigateToHome: () -> Unit = {},
    onNavigateToSignUp: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    composable<Route.SignIn> { navBackStackEntry->
        val email = navBackStackEntry.toRoute<Route.SignIn>().email
        val password = navBackStackEntry.toRoute<Route.SignIn>().password
        SignInRoute(
            userInputEmail = email,
            userInputPassword = password,
            onNavigateToHome = onNavigateToHome,
            onNavigateToSignUp = onNavigateToSignUp,
            modifier = modifier
        )
    }
}
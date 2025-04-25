package org.sopt.at.feature.signup.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.signup.SignUpRoute

fun NavController.navigateToSignUp() {
    navigate(Route.SignUp)
}
fun NavGraphBuilder.signUpNavGraph(
    modifier: Modifier = Modifier,
    onNavigateToSignIn: (String, String) -> Unit
) {
    composable<Route.SignUp> {
        SignUpRoute(
            modifier = modifier,
            onNavigateToSignIn = onNavigateToSignIn
        )
    }
}
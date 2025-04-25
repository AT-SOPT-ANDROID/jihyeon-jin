package org.sopt.at.feature.my.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.my.MyPageRoute
fun NavController.navigateToMyPage() {
    navigate(Route.MyPage)
}
fun NavGraphBuilder.myPageNavGraph(
    modifier: Modifier = Modifier,
    onNavigateToSignIn: (String, String) -> Unit
) {
    composable<Route.MyPage> {
        MyPageRoute(
            onNavigateToSignIn = onNavigateToSignIn,
            modifier = modifier
        )
    }
}
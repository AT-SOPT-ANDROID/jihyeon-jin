package org.sopt.at.feature.my.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.my.MyPageRoute
import org.sopt.at.feature.my.NicknameRoute

fun NavController.navigateToMyPage() {
    navigate(Route.MyPage)
}
fun NavController.navigateToNickname() {
    navigate(Route.Nickname)
}
fun NavGraphBuilder.myPageNavGraph(
    modifier: Modifier = Modifier,
    popBackStack: () -> Unit,
    onNavigateToNickname: () -> Unit,
    onNavigateToSignIn: () -> Unit
) {
    composable<Route.MyPage> {
        MyPageRoute(
            onNavigateToSignIn = onNavigateToSignIn,
            onNavigateToNickname = onNavigateToNickname,
            modifier = modifier
        )
    }
    composable<Route.Nickname> {
        NicknameRoute(
            popBackStack = popBackStack,
            modifier = modifier
        )
    }
}
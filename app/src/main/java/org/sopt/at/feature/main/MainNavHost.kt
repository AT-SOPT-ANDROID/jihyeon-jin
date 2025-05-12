package org.sopt.at.feature.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import org.sopt.at.feature.history.navigation.historyNavGraph
import org.sopt.at.feature.home.navigation.homeNavGraph
import org.sopt.at.feature.live.navigation.liveNavGraph
import org.sopt.at.feature.my.navigation.myPageNavGraph
import org.sopt.at.feature.search.navigation.searchNavGraph
import org.sopt.at.feature.shorts.navigation.shortsNavGraph
import org.sopt.at.feature.signin.navigation.signInNavGraph
import org.sopt.at.feature.signup.navigation.signUpNavGraph
import org.sopt.at.feature.splash.navigation.splashNavGraph
import org.sopt.at.ui.theme.TivingTheme.colors

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: MainNavigator
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.basicBlack)
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination,
            enterTransition = {
                EnterTransition.None
            },
            exitTransition = {
                ExitTransition.None
            },
            popEnterTransition = {
                EnterTransition.None
            },
            popExitTransition = {
                ExitTransition.None
            }
        ) {
            homeNavGraph(
                onNavigateToMyPage = navigator::navigateToMyPage,
            )
            shortsNavGraph()
            liveNavGraph()
            searchNavGraph()
            historyNavGraph()
            signInNavGraph(
                onNavigateToHome = navigator::navigateToHome,
                onNavigateToSignUp = navigator::navigateToSignUp,
                popBackStack = navigator::popBackStack
            )
            signUpNavGraph(
                popBackStack = navigator::popBackStack,
                onNavigateToSignIn = navigator::navigateToSignIn
            )
            splashNavGraph(
                onNavigateToHome = navigator::navigateToHome,
                onNavigateToSignIn = navigator::navigateToSignIn
            )
            myPageNavGraph(
                popBackStack = navigator::popBackStack,
                onNavigateToNickname = navigator::navigateToNickname,
                onNavigateToSignIn = navigator::navigateToSignIn
            )
        }
    }
}
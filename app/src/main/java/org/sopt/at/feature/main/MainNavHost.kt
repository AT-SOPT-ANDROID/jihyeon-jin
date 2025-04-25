package org.sopt.at.feature.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
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
import org.sopt.at.ui.theme.Black

@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
    padding: PaddingValues
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Black)
            .systemBarsPadding()
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination,
        ) {
            homeNavGraph(
                padding = padding,
                onNavigateToMyPage = navigator::navigateToMyPage
            )
            shortsNavGraph(
                padding = padding
            )
            liveNavGraph(
                padding = padding
            )
            searchNavGraph(
                padding = padding
            )
            historyNavGraph(
                padding = padding
            )
            signInNavGraph(
                onNavigateToHome = navigator::navigateToHome,
                onNavigateToSignUp = navigator::navigateToSignUp,
                padding = padding
            )
            signUpNavGraph(
                onNavigateToSignIn = { email, password ->
                    navigator.navigateToSignIn(email, password)
                },
                padding = padding,
            )
            splashNavGraph(
                onNavigateToHome = navigator::navigateToHome,
                onNavigateToSignIn = { email, password ->
                    navigator.navigateToSignIn(email, password)
                },
                padding = padding
            )
            myPageNavGraph(
                onNavigateToSignIn = { email, password ->
                    navigator.navigateToSignIn(email, password)
                },
                padding = padding
            )
        }
    }
}
package org.sopt.at.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.core.navigation.Route
import org.sopt.at.feature.history.navigation.navigateToHistory
import org.sopt.at.feature.home.navigation.navigateToHome
import org.sopt.at.feature.live.navigation.navigateToLive
import org.sopt.at.feature.my.navigation.navigateToMyPage
import org.sopt.at.feature.search.navigation.navigateToSearch
import org.sopt.at.feature.shorts.navigation.navigateToShorts
import org.sopt.at.feature.signin.navigation.navigateToSignIn
import org.sopt.at.feature.signup.navigation.navigateToSignUp

class MainNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = Route.Splash

    val currentTab: MainTab?
        @Composable get() = MainTab.entries.find { tab ->
            currentDestination?.route == tab.route::class.qualifiedName
        }

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(MainTab.HOME.route) {
                inclusive = false
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.HOME -> navController.navigateToHome(navOptions)
            MainTab.SHORTS -> navController.navigateToShorts(navOptions)
            MainTab.LIVE -> navController.navigateToLive(navOptions)
            MainTab.SEARCH -> navController.navigateToSearch(navOptions)
            MainTab.HISTORY -> navController.navigateToHistory(navOptions)
        }
    }


    fun navigateToSignIn(email: String, password: String) {
        navController.navigateToSignIn(email, password)
    }

    fun navigateToSignUp() {
        navController.navigateToSignUp()
    }

    fun navigateToMyPage() {
        navController.navigateToMyPage()
    }


    fun navigateToHome(navOptions: NavOptions? = null) {
        navController.navigateToHome(
            navOptions ?: navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        )
    }

    fun navigateToShorts(navOptions: NavOptions? = null) {
        navController.navigateToShorts(
            navOptions ?: navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        )
    }
    fun navigateToLive(navOptions: NavOptions? = null) {
        navController.navigateToLive(
            navOptions ?: navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        )
    }

    fun navigateToSearch(navOptions: NavOptions? = null) {
        navController.navigateToSearch(
            navOptions ?: navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        )
    }

    fun navigateToHistory(navOptions: NavOptions? = null) {
        navController.navigateToHistory(
            navOptions ?: navOptions {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        )
    }

    fun popBackStack() {
        navController.popBackStack()
    }
    private inline fun <reified T : Route> isSameCurrentDestination(): Boolean =
        navController.currentDestination?.route == T::class.qualifiedName

    @Composable
    fun shouldShowBottomBar(): Boolean {
        return currentDestination?.route?.let { currentRoute ->
            MainTab.entries.any { tab ->
                when (tab.route) {
                    is MainTabRoute.Home -> currentRoute.startsWith(MainTabRoute.Home::class.qualifiedName!!)
                    is MainTabRoute.Shorts -> currentRoute.startsWith(MainTabRoute.Shorts::class.qualifiedName!!)
                    is MainTabRoute.Live -> currentRoute.startsWith(MainTabRoute.Live::class.qualifiedName!!)
                    is MainTabRoute.Search -> currentRoute.startsWith(MainTabRoute.Search::class.qualifiedName!!)
                    is MainTabRoute.History -> currentRoute.startsWith(MainTabRoute.History::class.qualifiedName!!)
                }
            }
        } ?: false
    }
}

@Composable
fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}
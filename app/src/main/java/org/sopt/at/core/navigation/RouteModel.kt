package org.sopt.at.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Splash : Route

    @Serializable
    data object SignIn : Route

    @Serializable
    data object SignUp : Route

    @Serializable
    data object MyPage : Route
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute
    @Serializable
    data object Shorts : MainTabRoute
    @Serializable
    data object Live : MainTabRoute
    @Serializable
    data object Search : MainTabRoute
    @Serializable
    data object History : MainTabRoute
}
package org.sopt.at.feature.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import org.sopt.at.R
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.core.navigation.Route

enum class MainTab(
    @DrawableRes val defaultIconResId: Int,
    @DrawableRes val selectIconResId: Int,
    @StringRes val descriptionResId: Int,
    val route: MainTabRoute,
) {
    HOME(
        defaultIconResId = R.drawable.ic_home_default,
        selectIconResId =  R.drawable.ic_home_select,
        descriptionResId = R.string.bottom_navigation_bar_item_home,
        route = MainTabRoute.Home,
    ),
    SHORTS(
        defaultIconResId = R.drawable.ic_shorts_default,
        selectIconResId =  R.drawable.ic_shorts_select,
        descriptionResId = R.string.bottom_navigation_bar_item_shorts,
        MainTabRoute.Shorts
    ),
    LIVE(
        defaultIconResId = R.drawable.ic_live,
        selectIconResId =  R.drawable.ic_live,
        descriptionResId = R.string.bottom_navigation_bar_item_live,
        MainTabRoute.Live,
    ),
    SEARCH(
        defaultIconResId = R.drawable.ic_search,
        selectIconResId =  R.drawable.ic_search,
        descriptionResId = R.string.bottom_navigation_bar_item_search,
        MainTabRoute.Search,
    ),
    HISTORY(
        defaultIconResId = R.drawable.ic_history,
        selectIconResId =  R.drawable.ic_history,
        descriptionResId = R.string.bottom_navigation_bar_item_history,
        MainTabRoute.History,
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
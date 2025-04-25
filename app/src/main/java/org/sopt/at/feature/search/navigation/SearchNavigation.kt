package org.sopt.at.feature.search.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.sopt.at.core.navigation.MainTabRoute
import org.sopt.at.feature.search.SearchRoute
fun NavController.navigateToSearch(navOptions: NavOptions) {
    navigate(MainTabRoute.Search, navOptions)
}
fun NavGraphBuilder.searchNavGraph(
    padding: PaddingValues
) {
    composable<MainTabRoute.Search> {
        SearchRoute(
            padding = padding
        )
    }
}
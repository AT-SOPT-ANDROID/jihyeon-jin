package org.sopt.at.feature.search.navigation

import androidx.compose.ui.Modifier
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
    modifier: Modifier = Modifier
) {
    composable<MainTabRoute.Search> {
        SearchRoute(
            modifier = modifier
        )
    }
}
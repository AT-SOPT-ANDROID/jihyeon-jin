package org.sopt.at.feature.my

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.feature.my.viewmodel.MyPageViewModel
import org.sopt.at.ui.theme.TivingTheme.colors
import org.sopt.at.ui.theme.TivingTheme.typography

@Composable
fun MyPageRoute(
    onNavigateToSignIn: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MyPageViewModel = hiltViewModel()
) {
    MyPageScreen(
        onLogOutButtonClick = onNavigateToSignIn,
        modifier = modifier,
        viewModel = viewModel
    )
}
@Composable
fun MyPageScreen(
    onLogOutButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MyPageViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.sendEvent(MyPageContract.MyPageUiEvent.LoadAuthInfo)
    }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = state.id,
            style = typography.body.merge(colors.basicWhite),
        )

        Button(
            onClick = {
                viewModel.sendEvent(MyPageContract.MyPageUiEvent.LogOut)
                onLogOutButtonClick()
            }
        ) {
            Text(
                text = "로그아웃",
                style = typography.button.merge(colors.basicWhite),
            )
        }
    }

}
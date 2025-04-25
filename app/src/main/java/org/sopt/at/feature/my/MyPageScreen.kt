package org.sopt.at.feature.my

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.feature.my.viewmodel.MyPageViewModel
import org.sopt.at.ui.theme.White

@Composable
fun MyPageRoute(
    padding: PaddingValues,
    onNavigateToSignIn: (String, String) -> Unit,
    viewModel: MyPageViewModel = hiltViewModel()
) {
    MyPageScreen(
        padding = padding,
        onLogOutButtonClick = onNavigateToSignIn,
        viewModel = viewModel
    )
}
@Composable
fun MyPageScreen(
    padding : PaddingValues,
    onLogOutButtonClick: (String, String) -> Unit,
    viewModel: MyPageViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.sendEvent(MyPageContract.MyPageUiEvent.LoadAuthInfo)
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(padding)
    ) {
        Text(
            text = "zz4536",
            color = White
        )

        Button(
            onClick = {
                viewModel.sendEvent(MyPageContract.MyPageUiEvent.LogOut)
                onLogOutButtonClick("", "")
            }
        ) {
            Text("로그아웃")
        }
    }

}
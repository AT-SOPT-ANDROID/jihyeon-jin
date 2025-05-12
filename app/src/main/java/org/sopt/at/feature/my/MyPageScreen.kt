package org.sopt.at.feature.my

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.core.extension.noRippleClickable
import org.sopt.at.feature.my.contract.MyPageContract
import org.sopt.at.feature.my.viewmodel.MyPageViewModel
import org.sopt.at.ui.theme.TivingTheme.colors
import org.sopt.at.ui.theme.TivingTheme.typography

@Composable
fun MyPageRoute(
    onNavigateToSignIn: () -> Unit,
    modifier: Modifier = Modifier,
    onNavigateToNickname: () -> Unit,
    viewModel: MyPageViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.sendEvent(MyPageContract.MyPageUiEvent.LoadIdInfo)
        viewModel.sendEvent(MyPageContract.MyPageUiEvent.LoadNickname)
    }
    MyPageScreen(
        onLogOutButtonClick = {
            viewModel.sendEvent(MyPageContract.MyPageUiEvent.LogOut)
            onNavigateToSignIn()
        },
        onSettingButtonClick = onNavigateToNickname,
        modifier = modifier,
        state = state
    )
}
@Composable
private fun MyPageScreen(
    onLogOutButtonClick: () -> Unit,
    onSettingButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    state: MyPageContract.MyPageUiState,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = state.nickname,
                style = typography.body.merge(colors.basicWhite),
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = "설정",
                tint = colors.basicWhite,
                modifier = Modifier.noRippleClickable(onSettingButtonClick)
            )
        }
        Spacer(Modifier.weight(1f))
        Text(
            text = "로그아웃",
            style = typography.button.merge(colors.gray02),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(4.dp)
                )
                .border(
                    1.dp,
                    colors.gray02,
                    RoundedCornerShape(4.dp)
                )
                .padding(16.dp)
                .noRippleClickable(onLogOutButtonClick)
        )
    }

}
package org.sopt.at.feature.my

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.at.R
import org.sopt.at.core.component.BackButtonTopBar
import org.sopt.at.core.component.TivingCommonTextField
import org.sopt.at.core.extension.noRippleClickable
import org.sopt.at.feature.my.contract.NicknameContract
import org.sopt.at.feature.my.viewmodel.NicknameViewmodel
import org.sopt.at.ui.theme.TivingTheme.colors
import org.sopt.at.ui.theme.TivingTheme.typography

@Composable
fun NicknameRoute(
    popBackStack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: NicknameViewmodel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.sendEvent(NicknameContract.NicknameUiEvent.LoadIdInfo)
    }

    LaunchedEffect(state) {
        if (state.changeSuccess) {
            Toast.makeText(
                context,
                "닉네임이 수정되었습니다.",
                Toast.LENGTH_SHORT
            ).show()
            viewModel.clearErrorMessage()
            popBackStack()
        } else if(state.errorMessage.isNotEmpty()){
            Toast.makeText(
                context,
                state.errorMessage,
                Toast.LENGTH_SHORT
            ).show()
            viewModel.clearErrorMessage()
        }
    }

    NicknameScreen(
        onBackButtonClick = popBackStack,
        onChangeButtonClick = { nickname ->
            viewModel.sendEvent(
                NicknameContract.NicknameUiEvent.PatchNickname(nickname)
            )
        },
        onUpdateNickname = { nickname ->
            viewModel.updateNickname(nickname)
        },
        modifier = modifier,
        state = state
    )
}
@Composable
private fun NicknameScreen(
    onBackButtonClick: () -> Unit,
    onChangeButtonClick: (String) -> Unit,
    onUpdateNickname: (String) -> Unit,
    modifier: Modifier = Modifier,
    state: NicknameContract.NicknameUiState,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        BackButtonTopBar(
            onBackButtonPress = onBackButtonClick
        )
        Column(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        ) {

            Text(
                text = stringResource(R.string.sign_up_title_nickname),
                style = typography.title.merge(colors.basicWhite),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))
            TivingCommonTextField(
                value = state.nickname,
                hint = stringResource(R.string.sign_up_hint_nickname),
                onValueChange = { nickname ->
                    onUpdateNickname(nickname)
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.sign_up_nickname_caption),
                style = typography.caption.merge(colors.gray04)
            )

            Spacer(Modifier.weight(1f))
            Text(
                text = "수정",
                style = typography.button.merge(colors.gray02),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .imePadding()
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
                    .noRippleClickable{
                        onChangeButtonClick(state.nickname)
                    }
            )
        }
    }
}
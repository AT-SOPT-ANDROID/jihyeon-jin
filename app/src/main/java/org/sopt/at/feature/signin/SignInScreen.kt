package org.sopt.at.feature.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.launch
import org.sopt.at.R
import org.sopt.at.core.component.BackButtonTopBar
import org.sopt.at.core.component.TivingCommonPasswordField
import org.sopt.at.core.component.TivingCommonTextField
import org.sopt.at.core.extension.noRippleClickable
import org.sopt.at.core.utils.SnackBarUtils
import org.sopt.at.domain.model.SignInModel
import org.sopt.at.feature.signin.viewmodel.SignInViewModel
import org.sopt.at.ui.theme.TivingTheme.colors
import org.sopt.at.ui.theme.TivingTheme.typography

@Composable
fun SignInRoute(
    popBackStack: () -> Unit,
    onNavigateToHome: () -> Unit,
    onNavigateToSignUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val successText = stringResource(R.string.sign_in_success_login)

    LaunchedEffect(state) {
        if(state.loginSuccess){
            launch{
                SnackBarUtils.showSnackBar(
                    message = successText
                )
            }
            onNavigateToHome()
        } else if(state.errorMessage.isNotEmpty()){
            launch{
                SnackBarUtils.showSnackBar(
                    message = state.errorMessage
                )
            }
        }
    }
    SignInScreen(
        onBackButtonClick = popBackStack,
        onSignUpButtonClick = onNavigateToSignUp,
        onLogin = { email, password ->
            viewModel.sendEvent(
                SignInContract.SignInUiEvent.SignIn(
                    SignInModel(
                        email,
                        password
                    )
                )
            )
        },
        modifier = modifier
    )
}
@Composable
private fun SignInScreen(
    onBackButtonClick: () -> Unit,
    onSignUpButtonClick: () -> Unit,
    onLogin : (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val backgroundColor = if (id.isNotBlank() && password.isNotBlank())
        colors.brandRed
    else
        colors.gray04

    val buttonTextColor = if (id.isNotBlank() && password.isNotBlank())
        colors.basicWhite
    else
        colors.gray02

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
                    top = 0.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        ) {
            Spacer(Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.sign_in_title),
                color = colors.basicWhite,
                style = typography.title.merge(colors.basicWhite),
            )
            Spacer(Modifier.height(20.dp))
            TivingCommonTextField(
                value = id,
                hint = stringResource(R.string.sign_in_hint_id),
            ) {
                id = it
            }
            Spacer(Modifier.height(8.dp))
            TivingCommonPasswordField(
                value = password,
                hint = stringResource(R.string.sign_in_hint_pasword)
            ) {
                password = it
            }
            Spacer(Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.sign_in_text_button),
                style = typography.button.merge(buttonTextColor),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        backgroundColor,
                        RoundedCornerShape(7.dp)
                    )
                    .padding(14.dp)
                    .noRippleClickable {
                        onLogin(id, password)
                    }

            )
            Spacer(Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
            ) {
                Text(
                    text = stringResource(R.string.sign_in_find_id),
                    style = typography.body.merge(colors.gray01)
                )
                VerticalDivider(modifier = Modifier.height(16.dp), thickness = 1.dp, color = colors.gray01)
                Text(
                    text = stringResource(R.string.sign_in_find_password),
                    style = typography.body.merge(colors.gray01)
                )
                VerticalDivider(modifier = Modifier.height(16.dp), thickness = 1.dp, color = colors.gray01)
                Text(
                    text = stringResource(R.string.sign_in),
                    style = typography.body.merge(colors.gray01),
                    modifier = Modifier.noRippleClickable(onSignUpButtonClick)
                )
            }
            Spacer(Modifier.height(20.dp))
            Text(
                text = stringResource(R.string.sign_in_notice),
                style = typography.caption.merge(colors.gray04),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSignInScreen() {
    Column(Modifier.background(colors.basicBlack)) {
        SignInScreen(
            onSignUpButtonClick = { },
            onBackButtonClick = {},
            onLogin = { _, _ -> },
        )
    }
}
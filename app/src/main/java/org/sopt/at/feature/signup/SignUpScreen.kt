package org.sopt.at.feature.signup

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import org.sopt.at.domain.model.SignUpModel
import org.sopt.at.feature.signup.viewmodel.SignUpViewModel
import org.sopt.at.ui.theme.TivingTheme.colors
import org.sopt.at.ui.theme.TivingTheme.typography

enum class SignUpStep {
    ID, PASSWORD, NICKNAME
}

object SignUpValidator {
    val ID_REGEX = Regex("^[A-Za-z0-9]{8,20}$")
    val PASSWORD_REGEX = Regex("^[A-Za-z0-9]{8,20}$")
    val NICKNAME_REGEX = Regex("^[가-힣a-zA-Z0-9]{1,20}$")
}

@Composable
fun SignUpRoute(
    modifier: Modifier,
    popBackStack: () -> Unit,
    onNavigateToSignIn: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val signUpState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(signUpState) {
        if (signUpState.signUpSuccess) {
            launch {
                SnackBarUtils.showSnackBar(
                    message = context.getString(R.string.sign_up_success)
                )
            }
            onNavigateToSignIn()
        } else if (signUpState.errorMessage.isNotEmpty()) {
            Toast.makeText(
                context,
                signUpState.errorMessage,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    SignUpScreen(
        modifier = modifier,
        state = signUpState,
        onBackButtonPress = popBackStack,
        onNextButtonClick = { model ->
            viewModel.sendEvent(
                SignUpContract.SignUpUiEvent.SignUp(
                    model = model
                )
            )
        },
        onUpdateId = viewModel::updateId,
        onUpdatePassword = viewModel::updatePassword,
        onUpdateNickname = viewModel::updateNickname
    )
}

@Composable
private fun SignUpScreen(
    modifier: Modifier = Modifier,
    state: SignUpContract.SignUpUiState,
    onBackButtonPress: () -> Unit,
    onNextButtonClick: (SignUpModel) -> Unit,
    onUpdateId: (String) -> Unit,
    onUpdatePassword: (String) -> Unit,
    onUpdateNickname: (String) -> Unit
) {
    var step by remember { mutableStateOf(SignUpStep.ID) }

    val titleText = when (step) {
        SignUpStep.ID -> stringResource(R.string.sign_up_title_id)
        SignUpStep.PASSWORD -> stringResource(R.string.sign_up_title_password)
        SignUpStep.NICKNAME -> stringResource(R.string.sign_up_title_nickname)
    }

    val hintText = when (step) {
        SignUpStep.ID -> stringResource(R.string.sign_up_hint_id)
        SignUpStep.PASSWORD -> stringResource(R.string.sign_up_hint_password)
        SignUpStep.NICKNAME -> stringResource(R.string.sign_up_hint_nickname)
    }

    val isNextEnabled = when (step) {
        SignUpStep.ID -> SignUpValidator.ID_REGEX.matches(state.loginId)
        SignUpStep.PASSWORD -> SignUpValidator.PASSWORD_REGEX.matches(state.password)
        SignUpStep.NICKNAME -> SignUpValidator.NICKNAME_REGEX.matches(state.nickname)
    }

    val errorMessage = when (step) {
        SignUpStep.ID -> stringResource(R.string.sign_up_error_id)
        SignUpStep.PASSWORD -> stringResource(R.string.sign_up_error_password)
        SignUpStep.NICKNAME -> stringResource(R.string.sign_up_error_nickname)
    }

    val captionText = when (step) {
        SignUpStep.ID -> stringResource(R.string.sign_up_id_caption)
        SignUpStep.PASSWORD -> stringResource(R.string.sign_up_password_caption)
        SignUpStep.NICKNAME -> stringResource(R.string.sign_up_nickname_caption)
    }

    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        BackButtonTopBar(
            onBackButtonPress = onBackButtonPress
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
                text = titleText,
                style = typography.title.merge(colors.basicWhite),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            when (step) {
                SignUpStep.ID -> {
                    TivingCommonTextField(
                        value = state.loginId,
                        hint = hintText,
                        onValueChange = onUpdateId
                    )
                }

                SignUpStep.PASSWORD -> {
                    TivingCommonPasswordField(
                        value = state.password,
                        hint = hintText,
                        onValueChange = onUpdatePassword
                    )
                }
                SignUpStep.NICKNAME -> {
                    TivingCommonTextField(
                        value = state.nickname,
                        hint = hintText,
                        onValueChange = onUpdateNickname
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = captionText,
                style = typography.caption.merge(colors.gray04)
            )

            Spacer(Modifier.weight(1f))
            Text(
                text = "다음",
                style = typography.button.merge(
                    if (isNextEnabled) colors.basicBlack
                    else colors.gray02
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .imePadding()
                    .background(
                        color = if (isNextEnabled) colors.basicWhite
                        else Color.Transparent,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .border(
                        1.dp,
                        if (isNextEnabled) Color.Transparent else colors.gray02,
                        RoundedCornerShape(4.dp)
                    )
                    .padding(16.dp)
                    .noRippleClickable {
                        if (!isNextEnabled) {
                            Toast.makeText(
                                context,
                                errorMessage,
                                Toast.LENGTH_SHORT
                            ).show()
                            return@noRippleClickable
                        }

                        when (step) {
                            SignUpStep.ID -> step = SignUpStep.PASSWORD
                            SignUpStep.PASSWORD -> step = SignUpStep.NICKNAME
                            SignUpStep.NICKNAME -> onNextButtonClick(
                                SignUpModel(
                                    loginId = state.loginId,
                                    password = state.password,
                                    nickname = state.nickname
                                )
                            )
                        }
                    }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSignUpScreen() {
    Column(Modifier.background(colors.basicBlack)) {
        SignUpScreen(
            state = SignUpContract.SignUpUiState(),
            onBackButtonPress = {},
            onNextButtonClick = {},
            onUpdateId = {},
            onUpdatePassword = {},
            onUpdateNickname = {}
        )
    }
}
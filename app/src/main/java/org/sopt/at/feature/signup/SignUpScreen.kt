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
import org.sopt.at.R
import org.sopt.at.core.component.BackButtonTopBar
import org.sopt.at.core.component.TivingCommonPasswordField
import org.sopt.at.core.component.TivingCommonTextField
import org.sopt.at.core.extension.noRippleClickable
import org.sopt.at.ui.theme.TivingTheme.colors
import org.sopt.at.ui.theme.TivingTheme.typography

enum class SignUpStep {
    ID, PASSWORD, NICKNAME
}

@Composable
fun SignUpRoute(
    modifier: Modifier,
    popBackStack: () -> Unit,
    onNavigateToSignIn: () -> Unit
) {
    SignUpScreen(
        modifier = modifier,
        onBackButtonPress = popBackStack,
        onNextButtonClick = onNavigateToSignIn
    )
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onBackButtonPress: () -> Unit,
    onNextButtonClick: () -> Unit,
) {
    var step by remember { mutableStateOf(SignUpStep.ID) }
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var nickname by remember { mutableStateOf("") }

    val titleText = when (step) {
        SignUpStep.ID -> "아이디를 입력해주세요."
        SignUpStep.PASSWORD -> "비밀번호를 입력해주세요."
        SignUpStep.NICKNAME -> "닉네임을 입력해주세요"
    }

    val hintText = when (step) {
        SignUpStep.ID -> "아이디"
        SignUpStep.PASSWORD -> "비밀번호"
        SignUpStep.NICKNAME -> "닉네임"
    }

    val isNextEnabled = when (step) {
        SignUpStep.ID -> Regex("^[A-Za-z0-9]{8,20}$").matches(id)
        SignUpStep.PASSWORD -> Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#\$%^&*])[A-Za-z\\d~!@#\$%^&*]{8,15}\$")
            .matches(password)
        SignUpStep.NICKNAME -> Regex("^[가-힣a-zA-Z0-9]{1,20}$").matches(nickname)
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
                        value = id,
                        hint = hintText,
                        onValueChange = { id = it }
                    )
                }

                SignUpStep.PASSWORD -> {
                    TivingCommonPasswordField(
                        value = password,
                        hint = hintText,
                        onValueChange = { password = it }
                    )
                }
                SignUpStep.NICKNAME -> {
                    TivingCommonTextField(
                        value = nickname,
                        hint = hintText,
                        onValueChange = { nickname = it }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = when (step) {
                    SignUpStep.ID -> stringResource(R.string.sign_up_id_caption)
                    SignUpStep.PASSWORD -> stringResource(R.string.sign_up_password_caption)
                    SignUpStep.NICKNAME -> stringResource(R.string.sign_up_nickname_caption)
                },
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
                        color = if (isNextEnabled) colors.basicWhite else Color.Transparent,
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
                                when (step) {
                                    SignUpStep.ID -> "아이디 형식이 올바르지 않습니다."
                                    SignUpStep.PASSWORD -> "비밀번호 형식이 올바르지 않습니다."
                                    SignUpStep.NICKNAME -> "닉네임 형식이 올바르지 않습니다."
                                },
                                Toast.LENGTH_SHORT
                            ).show()
                            return@noRippleClickable
                        }

                        when (step) {
                            SignUpStep.ID -> step = SignUpStep.PASSWORD
                            SignUpStep.PASSWORD -> step = SignUpStep.NICKNAME
                            SignUpStep.NICKNAME -> onNextButtonClick()
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
            onBackButtonPress = {},
            onNextButtonClick = {}
        )
    }
}
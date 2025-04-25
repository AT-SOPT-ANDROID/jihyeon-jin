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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.sopt.at.core.component.BackButtonTopBar
import org.sopt.at.core.component.TivingCommonPasswordField
import org.sopt.at.core.component.TivingCommonTextField
import org.sopt.at.core.extension.noRippleClickable
import org.sopt.at.ui.theme.Black
import org.sopt.at.ui.theme.Gray2
import org.sopt.at.ui.theme.Gray4
import org.sopt.at.ui.theme.White

enum class SignUpStep {
    ID, PASSWORD
}

@Composable
fun SignUpRoute(
    modifier: Modifier,
    onNavigateToSignIn: (String, String) -> Unit
) {
    SignUpScreen(
        modifier = modifier,
        onNextButtonClick = onNavigateToSignIn
    )
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onNextButtonClick: (String, String) -> Unit = { _, _ -> },
) {
    var step by remember { mutableStateOf(SignUpStep.ID) }
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val titleText = when (step) {
        SignUpStep.ID -> "아이디를 입력해주세요."
        SignUpStep.PASSWORD -> "비밀번호를 입력해주세요."
    }

    val hintText = when (step) {
        SignUpStep.ID -> "아이디"
        SignUpStep.PASSWORD -> "비밀번호"
    }

    val isNextEnabled = when (step) {
        SignUpStep.ID -> Regex("^[a-z0-9]{6,12}$").matches(id)
        SignUpStep.PASSWORD -> Regex("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#\$%^&*])[A-Za-z\\d~!@#\$%^&*]{8,15}\$")
            .matches(password)
    }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        BackButtonTopBar(
            onBackButtonPress = { // TODO: 뒤로가기
            }
        )
        Column(
            modifier = Modifier
                .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {

            Text(
                text = titleText,
                color = White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
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
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = when (step) {
                    SignUpStep.ID -> "영문 소문자 또는 영문 소문자, 숫자 조합 6~12 자리"
                    SignUpStep.PASSWORD -> "영문, 숫자, 특수문자(~!@#$%^&*) 조합 8~15 자리"
                },
                fontSize = 14.sp,
                color = Gray4,
            )

            Spacer(Modifier.weight(1f))
            Text(
                text = "다음",
                color = if (isNextEnabled) Black else Gray2,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .imePadding()
                    .background(
                        color = if (isNextEnabled) White else Color.Transparent,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .border(
                        1.dp,
                        if (isNextEnabled) Color.Transparent else Gray2,
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
                                },
                                Toast.LENGTH_SHORT
                            ).show()
                            return@noRippleClickable
                        }

                        when (step) {
                            SignUpStep.ID -> step = SignUpStep.PASSWORD
                            SignUpStep.PASSWORD -> onNextButtonClick(id, password)
                        }
                    }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSignUpScreen() {
    Column(Modifier.background(Black)) {
        SignUpScreen()
    }
}
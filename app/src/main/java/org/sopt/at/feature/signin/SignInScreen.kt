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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import org.sopt.at.ui.theme.Gray1
import org.sopt.at.ui.theme.Gray2
import org.sopt.at.ui.theme.Gray4
import org.sopt.at.ui.theme.TivingPrimary
import org.sopt.at.ui.theme.White

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onLoginButtonClick: (String, String) -> Unit = { _, _ ->},
    onSignUpButtonClick: () -> Unit = {},
) {
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val backgroundColor = if (id.isNotBlank() && password.isNotBlank())
        TivingPrimary
    else
        Gray4
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
                .padding(top = 0.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
        ) {
            Spacer(Modifier.height(20.dp))
            Text(
                text = "TIVING ID 로그인",
                color = White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Spacer(Modifier.height(20.dp))
            TivingCommonTextField(
                value = id,
                hint = "아이디",
            ) {
                id = it
            }
            Spacer(Modifier.height(8.dp))
            TivingCommonPasswordField(
                value = password,
                hint = "비밀번호"
            ) {
                password = it
            }
            Spacer(Modifier.height(16.dp))
            Text(
                text = "로그인 하기",
                color = Gray2,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        backgroundColor,
                        RoundedCornerShape(7.dp)
                    )
                    .padding(14.dp)
                    .noRippleClickable {
                        onLoginButtonClick(id, password)
                    }

            )
            Spacer(Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "아이디 찾기",
                    color = Gray1,
                )
                VerticalDivider(modifier = Modifier.height(16.dp), thickness = 1.dp, color = Gray1)
                Text(
                    text = "비밀번호 찾기",
                    color = Gray1,
                )
                VerticalDivider(modifier = Modifier.height(16.dp), thickness = 1.dp, color = Gray1)
                Text(
                    text = "회원가입",
                    color = Gray1,
                    modifier = Modifier.noRippleClickable(onSignUpButtonClick)
                )
            }
            Spacer(Modifier.height(20.dp))
            Text(
                text = "이 사이트는 Google reCAPTCHA로 보호되며,\nGoogle 개인정보 처리 방침과 서비스 약관이 적용됩니다.",
                fontSize = 12.sp,
                color = Gray4,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
private fun PreviewSignInScreen() {
    Column(Modifier.background(Black)) {
        SignInScreen()
    }
}
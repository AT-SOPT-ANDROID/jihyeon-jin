package org.sopt.at.feature.my

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.sopt.at.ui.theme.White

@Composable
fun MyPageScreen(
    id:String,
    onLogOutButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = id,
            color = White
        )

        Button(
            onClick = onLogOutButtonClick,
            modifier = modifier
        ) {
            Text("로그아웃")
        }
    }

}
package org.sopt.at.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.at.ui.theme.TivingTheme.colors
import org.sopt.at.ui.theme.TivingTheme.typography

@Composable
fun TivingCommonTextField(
    value: String,
    hint: String,
    onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        textStyle = typography.body.merge(colors.basicWhite),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = hint,
                        style = typography.body.merge(colors.gray03)
                    )
                }
                innerTextField()

            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus(true)
            },
            onNext = {
                focusManager.moveFocus(FocusDirection.Down)
            }
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = colors.gray04,
                shape = RoundedCornerShape(7.dp),
            )
            .height(48.dp)
    )
}

@Preview
@Composable
private fun PreviewTivingCommonTextField() {
    TivingCommonTextField(
        value = "",
        hint = "아이디",
        onValueChange = {  }
    )
}
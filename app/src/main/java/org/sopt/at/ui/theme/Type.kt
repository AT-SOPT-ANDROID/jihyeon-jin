package org.sopt.at.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import org.sopt.at.R


val tivingBold = FontFamily(Font(R.font.pretendard_bold))
val tivingSemiBold = FontFamily(Font(R.font.pretendard_semibold))
val tivingRegular = FontFamily(Font(R.font.pretendard_regular))

@Immutable
data class TivingTypography(
    val title: TextStyle,
    val subTitle: TextStyle,
    val body: TextStyle,
    val button: TextStyle,
    val caption: TextStyle,
)

val defaultTivingTypography = TivingTypography(
    title = TextStyle(
        fontFamily = tivingBold,
        fontSize = 24.sp,
        lineHeight = 32.sp
    ),
    subTitle = TextStyle(
        fontFamily = tivingSemiBold,
        fontSize = 18.sp,
        lineHeight = 26.sp
    ),
    body = TextStyle(
        fontFamily = tivingRegular,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    button = TextStyle(
        fontFamily = tivingBold,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    caption = TextStyle(
        fontFamily = tivingRegular,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
)

val LocalTivingTypographyProvider = staticCompositionLocalOf { defaultTivingTypography }
package org.sopt.at.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object TivingTheme {
    val colors: TivingColors
        @Composable
        @ReadOnlyComposable
        get() = LocalTivingColorsProvider.current

    val typography: TivingTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTivingTypographyProvider.current
}

@Composable
fun ProvideTivingColorsAndTypography(
    colors: TivingColors,
    typography: TivingTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTivingColorsProvider provides colors,
        LocalTivingTypographyProvider provides typography,
        content = content
    )
}

@Composable
fun TivingTheme(
    content: @Composable () -> Unit
) {
    ProvideTivingColorsAndTypography(
        colors = defaultTivingColors,
        typography = defaultTivingTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = false
                }
            }
        }
        MaterialTheme(
            content = content
        )
    }
}
package org.sopt.at.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.sopt.at.core.extension.noRippleClickable
import org.sopt.at.ui.theme.Black
import org.sopt.at.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackButtonTopBar(
    onBackButtonPress: () -> Unit
) {
    CenterAlignedTopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Black),
        title = {},
        navigationIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowLeft,
                contentDescription = "",
                tint = White,
                modifier = Modifier
                    .size(32.dp)
                    .noRippleClickable { onBackButtonPress() }
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Black,
        )
    )
}
package org.sopt.at.feature.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import org.sopt.at.R
import org.sopt.at.core.extension.noRippleClickable
import org.sopt.at.ui.theme.Black
import org.sopt.at.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    onLogoClick: () -> Unit,
    onLiveButtonClick: () -> Unit,
    onProfileButtonClick: () -> Unit
) {
    TopAppBar(
        title = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_tving_logo),
                contentDescription = stringResource(R.string.app_name),
                tint = Color.Unspecified,
                modifier = Modifier.height(48.dp)
                    .noRippleClickable(onLogoClick)
            )
        },
        actions = {
            IconButton(onClick = onLiveButtonClick) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_cast),
                    contentDescription = stringResource(R.string.image_cennect),
                    tint = White,
                    modifier = Modifier.size(28.dp)
                )
            }
            IconButton(onClick = onProfileButtonClick) {
                Image(
                    painter = painterResource(R.drawable.image_profile),
                    contentDescription = stringResource(R.string.image_profile),
                    modifier = Modifier.size(28.dp)
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Black,
            titleContentColor = White
        ),
        modifier = Modifier.height(48.dp)
    )
}
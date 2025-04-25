package org.sopt.at.feature.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.delay
import org.sopt.at.R
import org.sopt.at.feature.splash.viewmodel.SplashViewModel
import org.sopt.at.ui.theme.Black

@Composable
fun SplashRoute(
    onNavigateToHome: () -> Unit,
    onNavigateToSignIn: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel = hiltViewModel()
) {
    SplashScreen(
        onNavigateToHome = onNavigateToHome,
        onNavigateToSignIn = onNavigateToSignIn,
        modifier = modifier,
        viewModel = viewModel
    )
}

@Composable
fun SplashScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToSignIn: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.sendEvent(SplashContract.SplashUiEvent.LoadIsLogin)
        delay(2500)
        if (state.isLogin) {
            onNavigateToHome()
        } else {
            onNavigateToSignIn("", "")
        }
    }
    Column(
        modifier = modifier
            .background(color = Black)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.logo_tiving),
            contentDescription = stringResource(R.string.splash_logo),
            tint = Color.Unspecified
        )
    }
}

package org.sopt.at.feature.signin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.sopt.at.MainActivity.Companion.ID
import org.sopt.at.MainActivity.Companion.IS_LOGGED_IN
import org.sopt.at.MainActivity.Companion.PASSWORD
import org.sopt.at.MainActivity.Companion.TIVING_PREFS
import org.sopt.at.core.component.BackButtonTopBar
import org.sopt.at.core.utils.SnackBarUtils
import org.sopt.at.feature.my.MyPageActivity
import org.sopt.at.feature.signup.SignUpActivity
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme
import org.sopt.at.ui.theme.Black

class SignInActivity : ComponentActivity() {
    private lateinit var signUpResult: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        var signedUpId = ""
        var signedUpPassword = ""

        signUpResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val data = result.data
                    signedUpId = data?.getStringExtra("userId") ?: ""
                    signedUpPassword = data?.getStringExtra("password") ?: ""
                }
            }

        enableEdgeToEdge()
        setContent {
            val snackbarHostState = remember { SnackbarHostState() }
            SnackBarUtils.init(snackbarHostState)
            val coroutineScope = rememberCoroutineScope()
            ATSOPTANDROIDTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                ) { innerPadding ->
                    SignInScreen(
                        modifier = Modifier.padding(innerPadding)
                            .background(Black),
                        onLoginButtonClick = { id, password ->
                            if (id == signedUpId && password == signedUpPassword
                                && id.isNotEmpty() && password.isNotEmpty()) {
                                val sharedPreferences =
                                    getSharedPreferences(TIVING_PREFS, MODE_PRIVATE)
                                with(sharedPreferences.edit()) {
                                    putString(ID, id)
                                    putString(PASSWORD, password)
                                    putBoolean(IS_LOGGED_IN, true)
                                    apply()
                                }
                                startActivity(
                                    Intent(
                                        this@SignInActivity,
                                        MyPageActivity::class.java
                                    )
                                )
                                finish()
                            } else
                                coroutineScope.launch {
                                    SnackBarUtils.showSnackBar(
                                        message = "아이디 또는 비밀번호가 일치하지 않습니다.",
                                        actionLabel = "닫기"
                                    )
                                }
                        },
                        onSignUpButtonClick = {
                            signUpResult.launch(Intent(this, SignUpActivity::class.java))
                        },
                    )
                }
            }
        }
    }
}
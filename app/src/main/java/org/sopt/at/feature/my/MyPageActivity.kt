package org.sopt.at.feature.my

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import org.sopt.at.feature.main.MainActivity
import org.sopt.at.feature.main.MainActivity.Companion.ID
import org.sopt.at.feature.main.MainActivity.Companion.TIVING_PREFS
import org.sopt.at.ui.theme.ATSOPTANDROIDTheme
import org.sopt.at.ui.theme.Black

class MyPageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val sharedPreferences = getSharedPreferences(TIVING_PREFS, MODE_PRIVATE)
            ATSOPTANDROIDTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    MyPageScreen(
                        id = sharedPreferences.getString(ID, "").orEmpty(),
                        onLogOutButtonClick = {
                            with(sharedPreferences.edit()) {
                                clear()
                                apply()
                            }
                            val intent = Intent(this, MainActivity::class.java).apply {
                                flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            }
                            startActivity(intent)
                            finish()
                        },
                        modifier = Modifier.padding(innerPadding)
                            .background(Black)
                    )
                }
            }
        }
    }
}
package org.sopt.at.core.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import androidx.core.content.edit


class PreferenceUtil @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val sharedPreferences =
        context.getSharedPreferences("tiving_prefs", Context.MODE_PRIVATE)

    fun saveUserId(userId: String) {
        sharedPreferences.edit { putString(USER_ID, userId) }
    }

    fun getUserId(): String {
        return sharedPreferences.getString(USER_ID, "").orEmpty()
    }

    fun saveUserPw(userPw: String) {
        sharedPreferences.edit { putString(USER_PW, userPw) }
    }

    fun getUserPw(): String {
        return sharedPreferences.getString(USER_PW, "").orEmpty()
    }
    fun saveLoginState(isLogin: Boolean){
        sharedPreferences.edit{putBoolean(IS_LOGIN,isLogin)}
    }
    fun getLoginState(): Boolean{
        return sharedPreferences.getBoolean(IS_LOGIN,false)
    }

    fun clearAllData() {
        sharedPreferences.edit { clear().apply()}
    }

    companion object {
        private const val USER_ID = "user_id"
        private const val USER_PW = "user_pw"
        private const val IS_LOGIN = "is_login"
    }
}
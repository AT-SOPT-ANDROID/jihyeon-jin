package org.sopt.at.core.utils

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class PreferenceUtil @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val sharedPreferences =
        context.getSharedPreferences("tiving_prefs", Context.MODE_PRIVATE)

    fun saveUserId(userId: Long) {
        sharedPreferences.edit { putLong(USER_ID, userId) }
    }

    fun getUserId(): Long {
        return sharedPreferences.getLong(USER_ID, -1)
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
        private const val IS_LOGIN = "is_login"
    }
}
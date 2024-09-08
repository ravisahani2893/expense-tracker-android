package com.example.expensetracker.preference

import android.content.Context
import android.content.SharedPreferences
import com.example.expensetracker.model.login.LoginResponse


class SharedPreference internal constructor(context: Context){

    private val pref: SharedPreferences =  context.getSharedPreferences(PreferenceConstant.PREF_NAME, Context.MODE_PRIVATE)


    fun saveUser(response: LoginResponse){
        saveUserName(response.username!!)
        saveUserEmail(response.email!!)
        saveToken(response.accessToken!!)
        saveUserLoginStatus(true)
    }

    private fun saveUserName(name: String) {
        pref.edit().putString(PreferenceConstant.KEY_USER_NAME, name).apply()
    }

    private fun saveUserEmail(email: String) {
        pref.edit().putString(PreferenceConstant.KEY_USER_NAME, email).apply()
    }

    private fun saveToken(token: String) {
        pref.edit().putString(PreferenceConstant.KEY_OAUTH_TOKEN, token).apply()
    }

    private fun saveUserLoginStatus(status: Boolean) {
        pref.edit().putBoolean(PreferenceConstant.KEY_IS_USER_LOGGED_IN, status).apply()
    }

    val userName: String?
        get() = pref.getString(PreferenceConstant.KEY_USER_NAME, "")

    val userEmail: String?
        get() = pref.getString(PreferenceConstant.KEY_USER_EMAIL, "")

    val token: String?
        get() = pref.getString(PreferenceConstant.KEY_OAUTH_TOKEN, "")

    val isUserLoggedIn: Boolean?
        get() = pref.getBoolean(PreferenceConstant.KEY_IS_USER_LOGGED_IN, false)



}

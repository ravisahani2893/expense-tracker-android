package com.example.expensetracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.expensetracker.preference.SharedPreference

class SplashScreenViewModel(application: Application)  : AndroidViewModel(application) {

    fun isUserLoggedIn() : Boolean {
        return SharedPreference(getApplication()).isUserLoggedIn!!
    }
}
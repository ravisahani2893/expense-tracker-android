package com.example.expensetracker

import android.app.Application
import com.example.expensetracker.preference.PreferenceManager

class ExpenseTrackerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        PreferenceManager.initSharedPreference(applicationContext)
    }
}
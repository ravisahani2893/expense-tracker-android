package com.example.expensetracker.preference

import android.content.Context

object PreferenceManager {

    private lateinit var sharedPreference: SharedPreference

    fun initSharedPreference(context: Context){
        sharedPreference= SharedPreference(context)
    }

    fun getSharedPreference() : SharedPreference{
        if(sharedPreference == null){
            throw IllegalStateException(
                SharedPreference::class.java.getSimpleName() +
                        " is not initialized, call initializeUserPreference(..) method first."
            )

        }
       return sharedPreference
    }

}
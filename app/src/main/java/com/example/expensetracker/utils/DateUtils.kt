package com.example.expensetracker.utils

import android.content.Context
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {


    fun formatDate(pattern :String, date:String): String? {
        val fmt: SimpleDateFormat = SimpleDateFormat(pattern, Locale.US)
       return fmt.format(date)
    }

}
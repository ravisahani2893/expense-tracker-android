package com.example.expensetracker.utils

import java.text.SimpleDateFormat
import java.util.Locale

object DateUtils {

    const val PATTERN_DATE = "dd MMM yyyy"

    fun formatExpenseDate(inputDate: String): String {
        // Input formatter that can handle single-digit months/days
        val inputFormat = SimpleDateFormat("yyyy-M-d", Locale.getDefault())

        // Output formatter to ensure the date is in yyyy-MM-dd format
        val outputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        // Parse the input date
        val date = inputFormat.parse(inputDate)

        // Return the formatted date as yyyy-MM-dd
        return outputFormat.format(date)
    }

    fun formatExpenseTime(inputTime: String): String {
        val inputFormat = SimpleDateFormat("h:m a", Locale.getDefault())

        // Output formatter to ensure time is in HH:mm a (e.g., "09:05 AM")
        val outputFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())

        // Parse the input time
        val date = inputFormat.parse(inputTime)

        // Return the formatted time as HH:mm a
        return outputFormat.format(date)
    }

    fun formatDateTime(inputDateTime: String):String{
        val outputFormat = SimpleDateFormat("yyyy-MM-dd hh:mm aa", Locale.getDefault())

        // Parse the input date
        val date = outputFormat.parse(inputDateTime)

        // Return the formatted date as yyyy-MM-dd
        return outputFormat.format(date)
    }

    fun formatDateTime(inputDateTime: String,pattern: String):String{
        val inputDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        val outputFormat = SimpleDateFormat(pattern, Locale.getDefault())

        // Parse the input date
        val date = inputDateFormat.parse(inputDateTime)

        // Return the formatted date as yyyy-MM-dd
        return outputFormat.format(date)
    }

}

package com.example.expensetracker.fragment

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.example.expensetracker.listener.OnTimeSelectListener
import java.util.Calendar

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {


    private lateinit var timeSelectListener: OnTimeSelectListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current time as the default values for the picker.
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)

        // Create a new instance of TimePickerDialog and return it.
        return TimePickerDialog(activity, this, hour, minute, false)
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        // Do something with the time the user picks.
        Log.d("time picker", hourOfDay.toString().plus(" ").plus(minute).plus(view.drawingTime))
        var hr: Int = view.hour
        var AM_PM = "AM"
        if (hr >= 12) {
            hr -= 12
            AM_PM = "PM"
        }
        timeSelectListener.onTimeSelected(hr.toString().plus(":").plus(minute).plus(" ").plus(AM_PM))

    }

    fun setTimeSelectListener(listener: OnTimeSelectListener){
        this.timeSelectListener=listener
    }
}
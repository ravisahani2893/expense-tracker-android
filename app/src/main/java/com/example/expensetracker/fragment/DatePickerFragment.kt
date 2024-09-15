package com.example.expensetracker.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.expensetracker.listener.OnDateSelectListener
import java.util.Calendar

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private lateinit var dateSelectListener: OnDateSelectListener


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current date as the default date in the picker.
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it.
        return DatePickerDialog(requireContext(), this, year, month, day)

    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        val selectedMonth= month+1
        dateSelectListener.onDateSelected(year.toString().plus("-").plus(selectedMonth).plus("-").plus(day))
    }

    fun setDateSelectListener(listener: OnDateSelectListener){
        this.dateSelectListener=listener
    }
}
package com.example.expensetracker.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatSpinner


class MySpinner(context: Context?, attrs: AttributeSet?) :
    AppCompatSpinner(context!!, attrs) {
    var listener: OnItemSelectedListener? = null

    override fun setSelection(position: Int) {
        super.setSelection(position)

        if (position == selectedItemPosition) {
            listener!!.onItemSelected(null, null, position, 0)
        }
    }

    override fun setOnItemSelectedListener(listener: OnItemSelectedListener?) {
        this.listener = listener
    }
}

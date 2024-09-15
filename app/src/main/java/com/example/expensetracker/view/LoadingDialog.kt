package com.example.expensetracker.view


import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import com.example.expensetracker.R


class LoadingDialog(context: Context) : Dialog(context) {
    private var dialog: Dialog? = null

    // Function to show the progress dialog
    fun showProgressDialog(isCancelable : Boolean): LoadingDialog? {
        if (dialog == null) {
            dialog = LoadingDialog(context)
            dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog?.setContentView(R.layout.layout_material_progress) // Use your custom layout for the dialog
            dialog?.setCancelable(isCancelable) // Disable dismiss by tapping outside the dialog

            // Set the message for the progress dialog (if there's a TextView for the message)
            val progressMessage: TextView? = dialog?.findViewById(R.id.progress_message)
            progressMessage?.text = "Loading..."

            // Set background as transparent
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        dialog?.show()
        return dialog as LoadingDialog
    }

    // Function to dismiss the progress dialog
    fun dismissProgressDialog() {
        if (dialog != null && dialog?.isShowing == true) {
            dialog?.dismiss()
            dialog = null
        }
    }
}

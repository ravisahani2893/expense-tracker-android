package com.example.expensetracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.expensetracker.manager.expense.ExpenseManager
import com.example.expensetracker.model.expense.ExpenseResponseItem
import com.example.expensetracker.network.model.DataResponse


class MainActivityViewModel  : ViewModel(){

    fun getExpenseList(): LiveData<DataResponse<List<ExpenseResponseItem>>> {
        return ExpenseManager.getExpenseList()
    }

}
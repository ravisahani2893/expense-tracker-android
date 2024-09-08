package com.example.expensetracker.manager.expense

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.expense.ExpenseResponseItem
import com.example.expensetracker.model.expense.create.ExpenseRequest
import com.example.expensetracker.model.expense.create.ExpenseResponse
import com.example.expensetracker.network.UrlProvider
import com.example.expensetracker.network.model.DataResponse
import com.example.expensetracker.service.Provider


object ExpenseApiManager {

    fun getExpenseList(): LiveData<DataResponse<List<ExpenseResponseItem>>> {
        return Provider.getExpenseService()
            .getExpenseList( UrlProvider.getExpenseUrl())
    }

    fun createExpense(expenseRequest: ExpenseRequest): LiveData<DataResponse<ExpenseResponse>> {
        return Provider.getExpenseService()
            .createExpense( UrlProvider.getCreateExpenseUrl(),expenseRequest)
    }

}
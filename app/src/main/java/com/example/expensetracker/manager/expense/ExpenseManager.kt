package com.example.expensetracker.manager.expense

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.expense.ExpenseResponseItem
import com.example.expensetracker.model.expense.create.ExpenseRequest
import com.example.expensetracker.model.expense.create.ExpenseResponse
import com.example.expensetracker.network.helper.NetworkResource
import com.example.expensetracker.network.model.DataResponse


object ExpenseManager {

    fun getExpenseList(): LiveData<DataResponse<List<ExpenseResponseItem>>> {
        return object : NetworkResource<List<ExpenseResponseItem>>() {
            override fun createCall(): LiveData<DataResponse<List<ExpenseResponseItem>>> {
                return ExpenseApiManager.getExpenseList()
            }
        }.apiResultLiveData
    }

    fun createExpense(request: ExpenseRequest): LiveData<DataResponse<ExpenseResponse>> {
        return object : NetworkResource<ExpenseResponse>() {
            override fun createCall(): LiveData<DataResponse<ExpenseResponse>> {
                return ExpenseApiManager.createExpense(request)
            }
        }.apiResultLiveData
    }

}
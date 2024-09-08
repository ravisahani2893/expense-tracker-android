package com.example.expensetracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.expensetracker.manager.category.CategoryManager
import com.example.expensetracker.manager.expense.ExpenseManager
import com.example.expensetracker.manager.login.LoginManager
import com.example.expensetracker.manager.subcategory.SubCategoryManager
import com.example.expensetracker.model.category.CategoryResponseItem
import com.example.expensetracker.model.expense.create.ExpenseRequest
import com.example.expensetracker.model.expense.create.ExpenseResponse
import com.example.expensetracker.model.login.LoginRequest
import com.example.expensetracker.model.login.LoginResponse
import com.example.expensetracker.model.subcategory.SubCategoryResponseItem
import com.example.expensetracker.network.model.DataResponse


class ExpenseViewModel  : ViewModel(){

    fun createExpense(request: ExpenseRequest): LiveData<DataResponse<ExpenseResponse>> {
        return ExpenseManager.createExpense(request)
    }

    fun getCategory(): LiveData<DataResponse<List<CategoryResponseItem>>> {
        return CategoryManager.getCategory()
    }

    fun getSubCategory(categoryId: Int): LiveData<DataResponse<List<SubCategoryResponseItem>>> {
        return SubCategoryManager.getSubCategory(categoryId)
    }

}
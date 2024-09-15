package com.example.expensetracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.expensetracker.manager.category.CategoryManager
import com.example.expensetracker.manager.expense.ExpenseManager
import com.example.expensetracker.manager.paymenttype.PaymentTypeManager
import com.example.expensetracker.manager.subcategory.SubCategoryManager
import com.example.expensetracker.model.category.CategoryResponseItem
import com.example.expensetracker.model.expense.create.request.ExpenseRequest
import com.example.expensetracker.model.expense.create.response.Category
import com.example.expensetracker.model.expense.create.response.ExpenseResponse
import com.example.expensetracker.model.paymenttype.PaymentTypeResponseItem
import com.example.expensetracker.model.subcategory.SubCategoryResponseItem
import com.example.expensetracker.network.model.DataResponse
import java.util.Date


class ExpenseViewModel : ViewModel() {

    fun createExpense(request: ExpenseRequest): LiveData<DataResponse<ExpenseResponse>> {
        return ExpenseManager.createExpense(request)
    }

    fun getCategory(): LiveData<DataResponse<List<CategoryResponseItem>>> {
        return CategoryManager.getCategory()
    }

    fun getSubCategory(categoryId: Int): LiveData<DataResponse<List<SubCategoryResponseItem>>> {
        return SubCategoryManager.getSubCategory(categoryId)
    }

    fun getPaymentType(): LiveData<DataResponse<List<PaymentTypeResponseItem>>> {
        return PaymentTypeManager.getPaymentType()
    }

    fun createExpenseRequest(
        categoryId: Int,
        subCategoryId: Int,
        paymentTypeId: Int,
        amount: String,
        expenseDate: String,
        description: String
    ): ExpenseRequest {
        val expenseRequest = ExpenseRequest()
        expenseRequest.categoryId = categoryId
        expenseRequest.subCategoryId = subCategoryId
        expenseRequest.paymentId = paymentTypeId
        expenseRequest.amount = amount.toInt()
        expenseRequest.expenseDate = expenseDate
        expenseRequest.expenseDescription = description
        return expenseRequest
    }

}
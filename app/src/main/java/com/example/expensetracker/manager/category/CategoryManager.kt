package com.example.expensetracker.manager.category

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.category.CategoryResponseItem
import com.example.expensetracker.model.expense.ExpenseResponseItem
import com.example.expensetracker.network.helper.NetworkResource
import com.example.expensetracker.network.model.DataResponse


object CategoryManager {

    fun getCategory(): LiveData<DataResponse<List<CategoryResponseItem>>> {
        return object : NetworkResource<List<CategoryResponseItem>>() {
            override fun createCall(): LiveData<DataResponse<List<CategoryResponseItem>>> {
                return CategoryApiManager.getCategory()
            }
        }.apiResultLiveData
    }

}
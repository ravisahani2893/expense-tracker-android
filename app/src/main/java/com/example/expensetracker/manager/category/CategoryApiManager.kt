package com.example.expensetracker.manager.category

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.category.CategoryResponseItem
import com.example.expensetracker.model.expense.ExpenseResponseItem
import com.example.expensetracker.network.UrlProvider
import com.example.expensetracker.network.model.DataResponse
import com.example.expensetracker.service.Provider


object CategoryApiManager {

    fun getCategory(): LiveData<DataResponse<List<CategoryResponseItem>>> {
        return Provider.getCategoryService()
            .getCategory( UrlProvider.getCategoryUrl())
    }

}
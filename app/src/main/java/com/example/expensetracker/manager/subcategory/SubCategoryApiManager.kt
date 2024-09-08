package com.example.expensetracker.manager.subcategory

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.category.CategoryResponseItem
import com.example.expensetracker.model.expense.ExpenseResponseItem
import com.example.expensetracker.model.subcategory.SubCategoryResponseItem
import com.example.expensetracker.network.UrlProvider
import com.example.expensetracker.network.model.DataResponse
import com.example.expensetracker.service.Provider


object SubCategoryApiManager {

    fun getSubCategory(categoryId : Int): LiveData<DataResponse<List<SubCategoryResponseItem>>> {
        return Provider.getSubCategoryService()
            .getSubCategory( UrlProvider.getSubCategoryCategoryUrl(categoryId))
    }

}
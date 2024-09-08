package com.example.expensetracker.manager.subcategory

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.subcategory.SubCategoryResponseItem
import com.example.expensetracker.network.helper.NetworkResource
import com.example.expensetracker.network.model.DataResponse


object SubCategoryManager {

    fun getSubCategory(categoryId: Int): LiveData<DataResponse<List<SubCategoryResponseItem>>> {
        return object : NetworkResource<List<SubCategoryResponseItem>>() {
            override fun createCall(): LiveData<DataResponse<List<SubCategoryResponseItem>>> {
                return SubCategoryApiManager.getSubCategory(categoryId)
            }
        }.apiResultLiveData
    }

}
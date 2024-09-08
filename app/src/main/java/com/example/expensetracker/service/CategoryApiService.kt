package com.example.expensetracker.service

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.category.CategoryResponseItem
import com.example.expensetracker.network.model.DataResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface CategoryApiService {

    @GET
    fun getCategory(@Url url : String): LiveData<DataResponse<List<CategoryResponseItem>>>

}
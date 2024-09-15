package com.example.expensetracker.service

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.category.CategoryResponseItem
import com.example.expensetracker.model.paymenttype.PaymentTypeResponseItem
import com.example.expensetracker.model.subcategory.SubCategoryResponseItem
import com.example.expensetracker.network.model.DataResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface PaymentTypeApiService {

    @GET
    fun getPaymentType(@Url url : String): LiveData<DataResponse<List<PaymentTypeResponseItem>>>

}
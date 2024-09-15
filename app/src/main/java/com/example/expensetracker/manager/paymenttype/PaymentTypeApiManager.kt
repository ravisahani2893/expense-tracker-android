package com.example.expensetracker.manager.paymenttype

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.paymenttype.PaymentTypeResponseItem
import com.example.expensetracker.network.UrlProvider
import com.example.expensetracker.network.model.DataResponse
import com.example.expensetracker.service.Provider


object PaymentTypeApiManager {

    fun getPaymentTypeList(): LiveData<DataResponse<List<PaymentTypeResponseItem>>> {
        return Provider.getPaymentTypeService()
            .getPaymentType( UrlProvider.getPaymentTypeUrl())
    }


}
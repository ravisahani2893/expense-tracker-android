package com.example.expensetracker.manager.paymenttype

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.paymenttype.PaymentTypeResponseItem
import com.example.expensetracker.network.helper.NetworkResource
import com.example.expensetracker.network.model.DataResponse


object PaymentTypeManager {

    fun getPaymentType(): LiveData<DataResponse<List<PaymentTypeResponseItem>>> {
        return object : NetworkResource<List<PaymentTypeResponseItem>>() {
            override fun createCall(): LiveData<DataResponse<List<PaymentTypeResponseItem>>> {
                return PaymentTypeApiManager.getPaymentTypeList()
            }
        }.apiResultLiveData
    }

}
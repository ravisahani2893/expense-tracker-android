package com.example.expensetracker.manager.login

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.login.LoginRequest
import com.example.expensetracker.model.login.LoginResponse
import com.example.expensetracker.network.helper.NetworkResource
import com.example.expensetracker.network.model.DataResponse


object LoginManager {


    fun login(request: LoginRequest): LiveData<DataResponse<LoginResponse>> {
        return object : NetworkResource<LoginResponse>() {
            override fun createCall(): LiveData<DataResponse<LoginResponse>> {
                return LoginApiManager.login(request)
            }
        }.apiResultLiveData
    }

}
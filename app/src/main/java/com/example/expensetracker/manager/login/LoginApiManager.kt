package com.example.expensetracker.manager.login

import androidx.lifecycle.LiveData
import com.example.expensetracker.model.login.LoginRequest
import com.example.expensetracker.model.login.LoginResponse
import com.example.expensetracker.network.UrlProvider
import com.example.expensetracker.network.model.DataResponse
import com.example.expensetracker.service.Provider


object LoginApiManager {

    fun login(userDetailsRequest: LoginRequest): LiveData<DataResponse<LoginResponse>> {
        return Provider.getLoginService()
            .login( UrlProvider.getLoginUrl(),userDetailsRequest)
    }

}
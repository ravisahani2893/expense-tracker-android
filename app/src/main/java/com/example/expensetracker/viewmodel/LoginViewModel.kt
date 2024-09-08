package com.example.expensetracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.expensetracker.manager.login.LoginManager
import com.example.expensetracker.model.login.LoginRequest
import com.example.expensetracker.model.login.LoginResponse
import com.example.expensetracker.network.model.DataResponse


class LoginViewModel  : ViewModel(){


    fun login(request: LoginRequest): LiveData<DataResponse<LoginResponse>> {
        return LoginManager.login(request)
    }

}
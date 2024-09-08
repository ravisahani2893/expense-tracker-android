package com.example.expensetracker.service

import com.example.expensetracker.network.RetrofitFactory

object Provider {

    private var loginApiService: LoginApiService? = null
    private var expenseApiService: ExpenseApiService? = null
    private var categoryApiService: CategoryApiService? = null
    private var subCategoryApiService: SubCategoryApiService? = null

    fun getLoginService() : LoginApiService {
        if(loginApiService == null){
            return RetrofitFactory.createService(LoginApiService::class.java)
        }
        return loginApiService!!

    }

    fun getExpenseService() : ExpenseApiService {
        if(expenseApiService == null){
            return RetrofitFactory.createService(ExpenseApiService::class.java)
        }
        return expenseApiService!!

    }

    fun getCategoryService() : CategoryApiService {
        if(categoryApiService == null){
            return RetrofitFactory.createService(CategoryApiService::class.java)
        }
        return categoryApiService!!

    }

    fun getSubCategoryService() : SubCategoryApiService {
        if(subCategoryApiService == null){
            return RetrofitFactory.createService(SubCategoryApiService::class.java)
        }
        return subCategoryApiService!!

    }
}
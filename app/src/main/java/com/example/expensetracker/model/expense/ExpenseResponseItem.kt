package com.example.expensetracker.model.expense

import com.fasterxml.jackson.annotation.JsonProperty

data class ExpenseResponseItem(

    @field:JsonProperty("createdAt")
    val createdAt: String? = null,

    @field:JsonProperty("expenseAmount")
    val expenseAmount: Any? = null,

    @field:JsonProperty("expenseDescription")
    val expenseDescription: String? = null,

    @field:JsonProperty("id")
    val id: Int? = null,

    @field:JsonProperty("categoryName")
    val categoryName: String? = null,

    @field:JsonProperty("subCategoryName")
    val subCategoryName: String? = null,

    @field:JsonProperty("paymentType")
    val paymentType: String? = null,

    @field:JsonProperty("updatedAt")
    val updatedAt: String? = null,

    @field:JsonProperty("expenseDate")
    val expenseDate: String? = null,

    @field:JsonProperty("expenseTime")
    val expenseTime: String? = null
)

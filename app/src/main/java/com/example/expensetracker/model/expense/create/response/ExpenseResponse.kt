package com.example.expensetracker.model.expense.create.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ExpenseResponse(

    @field:JsonProperty("createdAt")
	val createdAt: String? = null,

    @field:JsonProperty("expenseAmount")
	val expenseAmount: Int? = null,

    @field:JsonProperty("payment")
	val payment: Payment? = null,

    @field:JsonProperty("expenseDescription")
	val expenseDescription: String? = null,

    @field:JsonProperty("id")
	val id: Int? = null,

    @field:JsonProperty("subCategoryId")
	val subCategoryId: SubCategoryId? = null,

    @field:JsonProperty("category")
	val category: Category? = null,

    @field:JsonProperty("expenseDate")
	val expenseDate: String? = null,

    @field:JsonProperty("updatedAt")
	val updatedAt: String? = null
)
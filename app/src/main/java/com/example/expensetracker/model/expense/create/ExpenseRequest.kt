package com.example.expensetracker.model.expense.create

import com.fasterxml.jackson.annotation.JsonProperty

data class ExpenseRequest(

	@field:JsonProperty("amount")
	val amount: Int? = null,

	@field:JsonProperty("paymentId")
	val paymentId: Int? = null,

	@field:JsonProperty("expenseDescription")
	val expenseDescription: String? = null,

	@field:JsonProperty("subCategoryId")
	val subCategoryId: Int? = null,

	@field:JsonProperty("categoryId")
	val categoryId: Int? = null,

	@field:JsonProperty("expenseDate")
	val expenseDate: String? = null
)

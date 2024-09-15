package com.example.expensetracker.model.expense.create.request

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

data class ExpenseRequest(

	@field:JsonProperty("amount")
	var amount: Int? = null,

	@field:JsonProperty("paymentId")
	var paymentId: Int? = null,

	@field:JsonProperty("expenseDescription")
	var expenseDescription: String? = null,

	@field:JsonProperty("subCategoryId")
	var subCategoryId: Int? = null,

	@field:JsonProperty("categoryId")
	var categoryId: Int? = null,

	@field:JsonProperty("expenseDate")
	var expenseDate: String? = null
)

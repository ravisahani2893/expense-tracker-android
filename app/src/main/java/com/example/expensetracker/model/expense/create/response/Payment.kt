package com.example.expensetracker.model.expense.create.response

import com.fasterxml.jackson.annotation.JsonProperty

data class Payment(

	@field:JsonProperty("createdAt")
	val createdAt: String? = null,

	@field:JsonProperty("active")
	val active: Boolean? = null,

	@field:JsonProperty("id")
	val id: Int? = null,

	@field:JsonProperty("type")
	val type: String? = null,

	@field:JsonProperty("updatedAt")
	val updatedAt: String? = null
)
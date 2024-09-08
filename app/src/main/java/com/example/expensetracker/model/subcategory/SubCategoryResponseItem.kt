package com.example.expensetracker.model.subcategory

import com.fasterxml.jackson.annotation.JsonProperty

data class SubCategoryResponseItem(

	@field:JsonProperty("createdAt")
	val createdAt: String? = null,

	@field:JsonProperty("name")
	val name: String? = null,

	@field:JsonProperty("id")
	val id: Int? = null,

	@field:JsonProperty("updatedAt")
	val updatedAt: String? = null
)

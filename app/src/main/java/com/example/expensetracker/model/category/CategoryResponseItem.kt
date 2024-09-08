package com.example.expensetracker.model.category

import com.fasterxml.jackson.annotation.JsonProperty


data class CategoryResponseItem(

	@field:JsonProperty("createdAt")
	val createdAt: String? = null,

	@field:JsonProperty("name")
	val name: String? = null,

	@field:JsonProperty("id")
	val id: Int? = null,

	@field:JsonProperty("userId")
	val userId: Int? = null,

	@field:JsonProperty("updatedAt")
	val updatedAt: String? = null
)

package com.example.expensetracker.model.login

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginRequest(

	@field:JsonProperty("username")
	val username: String? = null,

	@field:JsonProperty("password")
val password: String? = null,
)

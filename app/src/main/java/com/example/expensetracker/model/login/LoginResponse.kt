package com.example.expensetracker.model.login

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginResponse(

	@field:JsonProperty("roles")
	val roles: List<String?>? = null,

	@field:JsonProperty("id")
	val id: Int? = null,

	@field:JsonProperty("accessToken")
	val accessToken: String? = null,

	@field:JsonProperty("tokenType")
	val tokenType: String? = null,

	@field:JsonProperty("email")
	val email: String? = null,

	@field:JsonProperty("username")
	val username: String? = null
)

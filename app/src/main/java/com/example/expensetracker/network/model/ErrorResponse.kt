package com.example.expensetracker.network.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty


@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorResponse {
    @get:JsonProperty("message")
    @set:JsonProperty("message")
    @JsonProperty("message")
    var message: String? = null

    @get:JsonProperty("status")
    @set:JsonProperty("status")
    @JsonProperty("status")
    var status: Boolean? = null
}

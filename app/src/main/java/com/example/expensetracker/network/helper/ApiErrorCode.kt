package com.example.expensetracker.network.helper

import java.util.EnumSet


enum class ApiErrorCode(val errorCode: Int, val cause: String) {
    WTF(-1, "Unknown"),
    NETWORK(0, ""),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED_TOKEN(401, "Unauthorized"),
    NOT_FOUND(404, "The requested resource was not found."),
    FORBIDDEN(403, "Access to that resource is forbidden."),
    TOO_MANY_REQUEST(420, "Too many requests to process"),
    FORCE_UPGRADE(426, "Upgrade Required"),
    SERVER_BUG(500, "There was an error on the server and the request could not be completed."),
    SERVER_MAINTENANCE(502, ""),
    REQUEST_FAILURE(503, "");


    override fun toString(): String {
        return errorCode.toString()
    }

    companion object {
        var serverErrorCodes: EnumSet<ApiErrorCode> =
            EnumSet.of(BAD_REQUEST, FORBIDDEN, SERVER_BUG, SERVER_MAINTENANCE)
        var authErrorCodes: EnumSet<ApiErrorCode> = EnumSet.of(
            UNAUTHORIZED_TOKEN
        )
    }
}


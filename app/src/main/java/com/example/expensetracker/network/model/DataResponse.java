package com.example.expensetracker.network.model;

import androidx.annotation.NonNull;

public class DataResponse<ResultType> {

    private final ResultType data;

    private final Status status;

    private final ErrorResponse errorMessage;

    private final int errorCode;
    public DataResponse(@NonNull ResultType data) {
        this.status = Status.SUCCESS;
        this.data = data;
        this.errorCode = -1;
        this.errorMessage = null;
    }

    public DataResponse(@NonNull Status status) {
        this.status = status;
        this.data = null;
        this.errorCode = -1;
        this.errorMessage = null;
    }

    public ResultType getData() {
        return data;
    }

    public DataResponse(int errorCode, ErrorResponse errorMessage) {
        this.status = Status.ERROR;
        this.data = null;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Status getStatus() {
        return status;
    }

    public enum Status {
        NETWORK_FETCH_SUCCESS, SUCCESS, ERROR, LOADING
    }

    public int getErrorCode() {
        return errorCode;
    }

    public ErrorResponse getErrorResponse() {
        return errorMessage;
    }

}


package com.example.expensetracker.network.helper;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.example.expensetracker.network.model.DataResponse;
import com.example.expensetracker.network.model.ErrorResponse;

public abstract class NetworkResource<ApiResponseType> {
    private MediatorLiveData<DataResponse<ApiResponseType>> apiResult;

    @MainThread
    protected NetworkResource() {
        apiResult = new MediatorLiveData<>();
        fetchFromNetwork();
    }

    // Called to create the API call.
    @NonNull
    @MainThread
    protected abstract LiveData<DataResponse<ApiResponseType>> createCall();

    // Called when the fetch fails. The child class may want to reset components
    // like rate limiter.
    @MainThread
    private void onFetchFailed(int errorCode, ErrorResponse errorResponse) {
        apiResult.setValue(new DataResponse<>(errorCode, errorResponse));
    }

    private void fetchFromNetwork() {
        final LiveData<DataResponse<ApiResponseType>> apiResponse = createCall();
        apiResult.setValue(new DataResponse<>(DataResponse.Status.LOADING));
        apiResult.addSource(apiResponse, response -> {
            apiResult.removeSource(apiResponse);
            if (response != null) {
                if (response.getData() != null) {
                    apiResult.setValue(response);
                } else {
                    onFetchFailed(response.getErrorCode(), response.getErrorResponse());
                }
            } else {
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setMessage(ApiErrorCode.NETWORK.getCause());

                onFetchFailed(ApiErrorCode.NETWORK.getErrorCode(), errorResponse); // TODO: Handle error
            }
        });
    }

    public MediatorLiveData<DataResponse<ApiResponseType>> getApiResultLiveData() {
        return apiResult;
    }
}


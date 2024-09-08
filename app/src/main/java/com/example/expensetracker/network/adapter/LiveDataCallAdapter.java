package com.example.expensetracker.network.adapter;


import com.example.expensetracker.network.model.DataResponse;
import com.example.expensetracker.network.model.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Type;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataCallAdapter<R> implements CallAdapter<R, LiveData<DataResponse<R>>> {

    private final Type responseType;

    public LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public LiveData<DataResponse<R>> adapt(@NonNull Call<R> call) {

        return new LiveData<DataResponse<R>>() {
            @Override
            protected void onActive() {
                super.onActive();
                call.clone().enqueue(new Callback<R>() {
                    @Override
                    public void onResponse(@NonNull Call<R> call1, @NonNull Response<R> response) {
                        if (call1.isCanceled()) return;

                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                postValue(new DataResponse<>(response.body()));
                            }else{
                                postValue(null);
                            }
                        } else {
                            ErrorResponse errorResponse = null;
                            if (response.errorBody() != null) {
                                errorResponse = getErrorResponse(response.errorBody());
                            }
                            postValue(new DataResponse<>(response.code(), errorResponse));
                        }
                    }


                    @Override
                    public void onFailure(@NonNull Call<R> call1, @NonNull Throwable t) {
                        if (call1.isCanceled()) return;
                        postValue(null);
                    }
                });
            }
        };
    }

    private ErrorResponse getErrorResponse(ResponseBody responseBody) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(responseBody.string(), ErrorResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ErrorResponse();

    }

}


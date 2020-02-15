package com.workmate.application.module.clocking.pattern;

import android.util.Log;

import com.google.gson.Gson;
import com.workmate.application.api.service.ApiManager;
import com.workmate.application.model.request.ClockRequest;
import com.workmate.application.model.request.LoginRequest;
import com.workmate.application.model.response.AuthResponse;
import com.workmate.application.model.response.ClockResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class ClockingDoInteractor implements ClockingInteractor {

    private static final String TAG = "Clocking Activity";

    @Override
    public void sendClockIn(ClockRequest clockRequest, OnListener listener) {
        Call<ClockResponse> getClock = ApiManager.getService().sendClockIn(clockRequest.getToken(), clockRequest);
        getClock.enqueue(new Callback<ClockResponse>() {
            @Override
            public void onResponse(Call<ClockResponse> call, Response<ClockResponse> response) {
                if (response.body() != null) {
                    ClockResponse clockResponse = response.body();
                    Log.i(TAG, "Response : " + new Gson().toJson(clockResponse));
                    if (clockResponse != null) {
                        listener.onSuccess(clockResponse);
                    }
                } else {
                    listener.onResponseNull();
                }
            }

            @Override
            public void onFailure(Call<ClockResponse> call, Throwable t) {

            }
        });

    }
}

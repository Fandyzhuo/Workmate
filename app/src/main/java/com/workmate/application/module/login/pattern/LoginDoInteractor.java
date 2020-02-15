package com.workmate.application.module.login.pattern;

import android.util.Log;

import com.google.gson.Gson;
import com.workmate.application.api.service.ApiManager;
import com.workmate.application.model.request.LoginRequest;
import com.workmate.application.model.response.AuthResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class LoginDoInteractor implements LoginInteractor {

    private static final String TAG = "Login Activity";

    @Override
    public void login(LoginRequest loginRequest, final OnListener listener) {
        Call<AuthResponse> getLogin = ApiManager.getService().sendLogin(loginRequest);
        getLogin.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.body() != null) {
                    AuthResponse authResponse = response.body();
                    Log.i(TAG, "Response : " + new Gson().toJson(authResponse));
                    if (authResponse != null) {
                        listener.onSuccess(authResponse);
                    }
                } else {
                    listener.onResponseNull();
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                listener.onErrorThrowable(t);
            }
        });

    }
}

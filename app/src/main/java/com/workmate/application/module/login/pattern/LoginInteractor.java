package com.workmate.application.module.login.pattern;

import com.workmate.application.model.request.LoginRequest;
import com.workmate.application.model.response.AuthResponse;

interface LoginInteractor {

    interface OnListener {

        void onSuccess(AuthResponse response);

        void onFailed(AuthResponse response);

        void onErrorThrowable(Throwable t);

        void onResponseNull();
    }

    void login(LoginRequest loginRequest, OnListener listener);

}

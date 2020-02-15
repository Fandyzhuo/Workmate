package com.workmate.application.module.login.pattern;

import android.app.Activity;
import android.util.Log;

import com.workmate.application.model.request.LoginRequest;
import com.workmate.application.model.response.AuthResponse;


public class LoginDoPresenter implements LoginPresenter, LoginInteractor.OnListener {

    private LoginView view;
    private LoginInteractor interactor;
    private Activity activity;

    public LoginDoPresenter(Activity activity, LoginView view) {
        this.activity = activity;
        this.view = view;
        interactor = new LoginDoInteractor();
    }

    @Override
    public void onSuccess(AuthResponse response) {
        if (view != null) {
            Log.i("Login Activity", "Success");
            view.getLogin(response);
        }
    }

    @Override
    public void onFailed(AuthResponse response) {
    }

    @Override
    public void onErrorThrowable(Throwable t) {
        if (view != null) {
            Log.e("Login Activity", t.toString());
        }
    }

    @Override
    public void onResponseNull() {
        if (view != null) {
            Log.e("Login Activity", "Response Null");
            activity.finish();
        }
    }


    @Override
    public void login(LoginRequest loginRequest) {
        if (view != null) {
            interactor.login(loginRequest, this);
        }
    }
}

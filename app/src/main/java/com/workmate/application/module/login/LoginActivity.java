package com.workmate.application.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.workmate.application.base.BaseActivity;
import com.workmate.application.module.main.MainActivity;
import com.workmate.application.R;
import com.workmate.application.model.request.LoginRequest;
import com.workmate.application.model.response.AuthResponse;
import com.workmate.application.module.login.pattern.LoginDoPresenter;
import com.workmate.application.module.login.pattern.LoginPresenter;
import com.workmate.application.module.login.pattern.LoginView;
import com.workmate.application.utils.NetworkUtils;
import com.workmate.application.utils.Session;

public class LoginActivity extends BaseActivity implements LoginView {

    private LoginPresenter loginPresenter;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        getSupportActionBar().hide();

        loginPresenter = new LoginDoPresenter(this, this);
        session = new Session(this);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                login();
            }
        }, secondsDelayed * 1000);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void login() {
        if (NetworkUtils.isNetAvailable(this)) {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setUsername("+6281313272005");
            loginRequest.setPassword("alexander");
            loginPresenter.login(loginRequest);
        }
    }

    @Override
    public void getLogin(AuthResponse response) {
        session.setKey(response.getKey());
        Log.i("key", "Response : " + response.getKey());
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onShowAlertDialog(String title, String message) {

    }

    @Override
    public void onShowToast(String message) {

    }

    @Override
    public void onHideDialog() {

    }
}

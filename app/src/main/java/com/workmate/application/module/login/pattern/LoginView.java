package com.workmate.application.module.login.pattern;

import com.workmate.application.model.response.AuthResponse;

public interface LoginView {
    void login();

    void getLogin(AuthResponse response);
}

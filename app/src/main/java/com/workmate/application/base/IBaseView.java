package com.workmate.application.base;

public interface IBaseView {

    void onShowAlertDialog(String title, String message);

    void onShowToast(String message);

    void onHideDialog();
}

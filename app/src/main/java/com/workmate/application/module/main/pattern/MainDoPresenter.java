package com.workmate.application.module.main.pattern;

import android.app.Activity;

import com.workmate.application.model.Staff;


public class MainDoPresenter implements MainPresenter, MainInteractor.OnListener {

    private MainView view;
    private MainInteractor interactor;
    private Activity activity;

    public MainDoPresenter(Activity activity, MainView view) {
        this.activity = activity;
        this.view = view;
        interactor = new MainDoInteractor();
    }


    @Override
    public void onSuccess(Staff staff) {
        if (view != null) {
            view.getStaff(staff);
        }
    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void sendStaff() {
        if (view != null) {
            interactor.getStaff(this);
        }
    }
}

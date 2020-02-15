package com.workmate.application.module.clocking.pattern;

import android.app.Activity;
import android.util.Log;

import com.workmate.application.model.request.ClockRequest;
import com.workmate.application.model.request.LoginRequest;
import com.workmate.application.model.response.AuthResponse;
import com.workmate.application.model.response.ClockResponse;


public class ClockingDoPresenter implements ClockingPresenter, ClockingInteractor.OnListener {

    private ClockingView view;
    private ClockingInteractor interactor;
    private Activity activity;

    public ClockingDoPresenter(Activity activity, ClockingView view) {
        this.activity = activity;
        this.view = view;
        interactor = new ClockingDoInteractor();
    }

    @Override
    public void onSuccess(ClockResponse response) {
        if (view != null) {
            Log.i("Clocking Activity", "Success");
            view.getClockIn(response);
        }
    }

    @Override
    public void onFailed(ClockResponse response) {
    }

    @Override
    public void onSuccessClockOut(ClockResponse response) {
        if (view != null) {
            Log.i("Clocking Activity", "Success");
            view.getClockOut(response);
        }
    }

    @Override
    public void onFailClockOut(ClockResponse response) {

    }

    @Override
    public void onErrorThrowable(Throwable t) {
        if (view != null) {
            Log.e("Clocking Activity", t.toString());
        }
    }

    @Override
    public void onResponseNull() {
        if (view != null) {
            Log.e("Clocking Activity", "Response Null");
            activity.finish();
        }
    }

    @Override
    public void sendClockIn(ClockRequest clockRequest) {
        if (view != null) {
            interactor.sendClockIn(clockRequest, this);
        }
    }

    @Override
    public void sendClockOut(ClockRequest clockRequest) {
        if (view != null) {
            interactor.sendClockOut(clockRequest, this);
        }
    }
}

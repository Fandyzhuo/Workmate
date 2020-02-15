package com.workmate.application.module.clocking.pattern;

import com.workmate.application.model.request.ClockRequest;
import com.workmate.application.model.response.ClockResponse;

interface ClockingInteractor {

    interface OnListener {

        void onSuccess(ClockResponse response);

        void onFailed(ClockResponse response);

        void onErrorThrowable(Throwable t);

        void onResponseNull();
    }

    void sendClockIn(ClockRequest clockRequest, OnListener listener);

}

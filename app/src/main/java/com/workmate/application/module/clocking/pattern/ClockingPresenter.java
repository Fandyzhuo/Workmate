package com.workmate.application.module.clocking.pattern;

import com.workmate.application.model.request.ClockRequest;

public interface ClockingPresenter {
    void sendClockIn(ClockRequest clockRequest);

    void sendClockOut(ClockRequest clockRequest);
}

package com.workmate.application.module.clocking.pattern;

import com.workmate.application.model.response.ClockResponse;

public interface ClockingView {
    void clockIn();

    void getClockIn(ClockResponse response);
}

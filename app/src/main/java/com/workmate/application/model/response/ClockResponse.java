package com.workmate.application.model.response;

public class ClockResponse {

    private String clock_in_time;
    private String clock_out_time;

    public String getClock_in_time() {
        return clock_in_time;
    }

    public void setClock_in_time(String clock_in_time) {
        this.clock_in_time = clock_in_time;
    }

    public String getClock_out_time() {
        return clock_out_time;
    }

    public void setClock_out_time(String clock_out_time) {
        this.clock_out_time = clock_out_time;
    }
}

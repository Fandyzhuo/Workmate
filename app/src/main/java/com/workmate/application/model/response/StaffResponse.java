package com.workmate.application.model.response;

import com.workmate.application.model.Staff;

public class StaffResponse {

    private Staff client;

    public Staff getStaff() {
        return client;
    }

    public void setStaff(Staff staff) {
        this.client = staff;
    }
}

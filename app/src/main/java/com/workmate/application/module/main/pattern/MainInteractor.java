package com.workmate.application.module.main.pattern;
import com.workmate.application.model.Staff;

public interface MainInteractor {

    void getStaff(MainInteractor.OnListener listener);

    interface OnListener {

        void onSuccess(Staff staff);

        void onFailed(String message);

    }
}

package com.workmate.application.module.main.pattern;

import android.util.Log;

import com.google.gson.Gson;
import com.workmate.application.api.service.ApiManager;
import com.workmate.application.model.Staff;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainDoInteractor implements MainInteractor {

    private static final String TAG = "Main Activity";

    @Override
    public void getStaff(final OnListener listener) {
        Call<Staff> getStaff = ApiManager.getService().sendStaffRequest();
        getStaff.enqueue(new Callback<Staff>() {
            @Override
            public void onResponse(Call<Staff> call, Response<Staff> response) {
                if (response.body() != null) {
                    Staff staff = response.body();
                    Log.i(TAG, "Response : " + new Gson().toJson(staff));
                    Log.i(TAG, "Response Isi" + staff.getWage_amount());
                    listener.onSuccess(staff);
                } else {
                    Log.i(TAG, "Gagal response staff");
                }
            }

            @Override
            public void onFailure(Call<Staff> call, Throwable t) {
                Log.i(TAG, "Failure response");
            }
        });
    }
}

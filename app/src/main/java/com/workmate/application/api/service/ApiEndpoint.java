package com.workmate.application.api.service;
import com.workmate.application.api.ApiKeys;
import com.workmate.application.model.Staff;
import com.workmate.application.model.request.LoginRequest;
import com.workmate.application.model.response.AuthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndpoint {

    @POST(ApiKeys.LOGIN)
    Call<AuthResponse>
    sendLogin(@Body LoginRequest loginRequest);

    @GET(ApiKeys.STAFF_REQUESTS)
    Call<Staff>
    sendStaffRequest();
}
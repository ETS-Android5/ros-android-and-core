package com.robotsdna.robot;

import com.robotsdna.robona.service.Requests.LoginRequest;
import com.robotsdna.robona.service.Responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RobonaService {

    @POST("/Login")
    Call<LoginResponse> login(@Body LoginRequest body);

}

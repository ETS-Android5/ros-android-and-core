package com.robotsdna.robot;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    public static RobonaService client() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://clientapi.robotsdna.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RobonaService.class);
    }
}

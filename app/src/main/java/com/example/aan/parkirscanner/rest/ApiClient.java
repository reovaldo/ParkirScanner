package com.example.aan.parkirscanner.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 27/05/17.
 */

public class ApiClient {

    //BASE URL DARI NAMA SITUS/DOMAIN
    public static final String BASE_URL = "http://192.168.0.150:8000/";

    public static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

package com.example.aan.parkirscanner.rest;

import com.example.aan.parkirscanner.model.Items;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by root on 27/05/17.
 */

public interface ApiInterface {

    @GET("{no_nim}")
    Call<Items> getDataMahasiswa(@Path("no_nim") String no_nim);



}


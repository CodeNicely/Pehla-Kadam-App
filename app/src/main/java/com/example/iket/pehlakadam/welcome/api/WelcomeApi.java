package com.example.iket.pehlakadam.welcome.api;

import com.example.iket.pehlakadam.helper.Urls;
import com.example.iket.pehlakadam.welcome.model.data.WelcomeData;

import retrofit2.Call;
import retrofit2.http.GET;


public interface WelcomeApi {

    @GET(Urls.WELCOME)
    Call<WelcomeData> requestWelcomeData();
}

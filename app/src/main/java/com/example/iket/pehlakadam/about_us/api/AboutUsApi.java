package com.example.iket.pehlakadam.about_us.api;
import com.example.iket.pehlakadam.about_us.model.data.AboutUsData;
import com.example.iket.pehlakadam.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AboutUsApi {


    @GET(Urls.SUB_URL_ABOUT_US)
    Call<AboutUsData> getAboutUsData();


}

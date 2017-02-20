package com.example.iket.pehlakadam.welcome.model;

import com.example.iket.pehlakadam.helper.Urls;
import com.example.iket.pehlakadam.welcome.WelcomeCallBack;
import com.example.iket.pehlakadam.welcome.api.WelcomeApi;
import com.example.iket.pehlakadam.welcome.model.data.WelcomeData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aman on 4/2/17.
 */

public class RetrofitWelcomeProvider implements WelcomeProvider {

    private WelcomeApi welcomeApi;

    private Retrofit retrofit;

    public RetrofitWelcomeProvider()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson=new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

    }

    @Override
    public void requestWelcomeData(final WelcomeCallBack welcomeCallBack) {
        welcomeApi = retrofit.create(WelcomeApi.class);
        Call<WelcomeData> call = welcomeApi.requestWelcomeData();
        call.enqueue(new Callback<WelcomeData>() {
            @Override
            public void onResponse(Call<WelcomeData> call, Response<WelcomeData> response) {
                welcomeCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<WelcomeData> call, Throwable t) {
                t.printStackTrace();
                welcomeCallBack.onFailure();
            }
        });
    }
}

package com.example.iket.pehlakadam.about_us.model;

import com.example.iket.pehlakadam.about_us.AboutUsCallBack;
import com.example.iket.pehlakadam.about_us.api.AboutUsApi;
import com.example.iket.pehlakadam.about_us.model.data.AboutUsData;
import com.example.iket.pehlakadam.helper.Urls;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by meghal on 13/10/16.
 */

public class RetrofitAboutUsProvider implements AboutUsProvider {

    private AboutUsApi aboutUsApi;
    private Call<AboutUsData> aboutUsDataCall;
    public RetrofitAboutUsProvider(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        aboutUsApi = retrofit.create(AboutUsApi.class);

    }


    @Override
    public void requestAboutUs(final AboutUsCallBack aboutUsCallBack) {

        aboutUsDataCall=aboutUsApi.getAboutUsData();

        aboutUsDataCall.enqueue(new Callback<AboutUsData>() {
            @Override
            public void onResponse(Call<AboutUsData> call, Response<AboutUsData> response) {

                aboutUsCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<AboutUsData> call, Throwable t) {

                aboutUsCallBack.onFailure();
                t.printStackTrace();
            }
        });

    }

    @Override
    public void onDestroy() {
        aboutUsDataCall.cancel();
    }
}

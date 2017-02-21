package com.example.iket.pehlakadam.imageViewer.model;

import com.example.iket.pehlakadam.helper.Urls;
import com.example.iket.pehlakadam.imageViewer.api.RequestApiImages;
import com.example.iket.pehlakadam.imageViewer.view.OnImagesReceived;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Iket on 8/21/2016.
 */
public class RetrofitImageProvider implements ImageProvider {

    @Override
    public ImageList reqImages(final OnImagesReceived onImagesReceived) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        final RequestApiImages request = retrofit.create(RequestApiImages.class);
        Call<ImageList> call=request.getImages();

        call.enqueue(new Callback<ImageList>() {
            @Override
            public void onResponse(Call<ImageList> call, Response<ImageList> response) {
                onImagesReceived.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<ImageList> call, Throwable t) {
                onImagesReceived.onFailure();
                t.printStackTrace();
            }
        });


        return null;
    }

}

package com.example.iket.pehlakadam.gallery.api;

import com.example.iket.pehlakadam.gallery.model.data.GalleryData;
import com.example.iket.pehlakadam.helper.Urls;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GalleryApi {


    @GET(Urls.SUB_URL_GALLERY)
    Call<GalleryData> getImageUrls();

}

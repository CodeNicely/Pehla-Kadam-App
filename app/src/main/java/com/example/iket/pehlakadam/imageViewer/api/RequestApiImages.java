package com.example.iket.pehlakadam.imageViewer.api;

import com.example.iket.pehlakadam.helper.Urls;
import com.example.iket.pehlakadam.imageViewer.model.ImageList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Iket on 8/21/2016.
 */
public interface RequestApiImages {
    @GET(Urls.REQUEST_IMAGES)
    Call<ImageList> getImages();
}

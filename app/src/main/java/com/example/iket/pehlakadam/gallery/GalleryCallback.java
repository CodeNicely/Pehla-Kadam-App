package com.example.iket.pehlakadam.gallery;


import com.example.iket.pehlakadam.gallery.model.data.GalleryData;

/**
 * Created by meghal on 13/10/16.
 */

public interface GalleryCallback {


    void onSuccess(GalleryData galleryData);
    void onFailure();

}

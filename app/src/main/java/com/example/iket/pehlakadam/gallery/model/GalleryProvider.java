package com.example.iket.pehlakadam.gallery.model;


import com.example.iket.pehlakadam.gallery.GalleryCallback;

/**
 * Created by meghal on 13/10/16.
 */

public interface GalleryProvider {

    void getImageUrls(GalleryCallback galleryCallback);
    void onDestroy();

}

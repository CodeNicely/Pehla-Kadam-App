package com.example.iket.pehlakadam.gallery.view;


import com.example.iket.pehlakadam.gallery.model.data.GalleryData;

/**
 * Created by meghal on 13/10/16.
 */

public interface GalleryView {

    void showLoader(boolean show);
    void showMessage(String message);
    void setData(GalleryData galleryData);
}

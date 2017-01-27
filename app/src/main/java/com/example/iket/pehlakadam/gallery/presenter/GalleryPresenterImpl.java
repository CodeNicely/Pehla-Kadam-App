package com.example.iket.pehlakadam.gallery.presenter;


import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.gallery.GalleryCallback;
import com.example.iket.pehlakadam.gallery.model.GalleryProvider;
import com.example.iket.pehlakadam.gallery.model.data.GalleryData;
import com.example.iket.pehlakadam.gallery.view.GalleryView;
import com.example.iket.pehlakadam.helper.MyApplication;

/**
 * Created by meghal on 13/10/16.
 */

public class GalleryPresenterImpl implements GalleryPresenter {

    private GalleryView galleryView;
    private GalleryProvider galleryProvider;

    public GalleryPresenterImpl(GalleryView galleryView, GalleryProvider galleryProvider) {
        this.galleryView = galleryView;
        this.galleryProvider = galleryProvider;
    }

    @Override
    public void getImageUrls() {

        galleryView.showLoader(true);
        galleryProvider.getImageUrls(new GalleryCallback() {
            @Override
            public void onSuccess(GalleryData galleryData) {

                galleryView.showLoader(false);

                if(galleryData.isSuccess())
                    galleryView.setData(galleryData);
                else
                    galleryView.showMessage(galleryData.getMessage());
            }

            @Override
            public void onFailure() {

                galleryView.showLoader(false);
                galleryView.showMessage(MyApplication.getContext().getResources().getString(R.string.failure_message));
            }
        });

    }

    @Override
    public void onDestroy() {

        galleryProvider.onDestroy();

    }
}

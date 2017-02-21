package com.example.iket.pehlakadam.imageViewer.presenter;

import android.util.Log;

import com.example.iket.pehlakadam.imageViewer.model.ImageList;
import com.example.iket.pehlakadam.imageViewer.model.ImageProvider;
import com.example.iket.pehlakadam.imageViewer.model.ImagesData;
import com.example.iket.pehlakadam.imageViewer.view.ImagesInterface;
import com.example.iket.pehlakadam.imageViewer.view.OnImagesReceived;

import java.util.List;



public class ImagePresenterImpl implements ImagePresenter {
    private ImagesInterface imagesInterface;
    private ImageProvider imagesProvider;

    public ImagePresenterImpl(ImagesInterface imagesInterface, ImageProvider imagesProvider) {
        this.imagesInterface = imagesInterface;
        this.imagesProvider = imagesProvider;
    }

    @Override
    public void requestImages() {
        Log.d("Response","1");
        imagesInterface.showLoading(true);
        imagesProvider.reqImages(new OnImagesReceived() {
            @Override
            public void onFailure() {
                Log.d("Response","2");
                imagesInterface.showLoading(false);
                imagesInterface.showMessage("Try again in some time");
            }

            @Override
            public void onSuccess(ImageList imageList) {
                Log.d("Response","3");
                Log.d("Response",""+imageList.isSuccess());
                imagesInterface.setData(imageList.getImages());
                imagesInterface.showLoading(false);
            }
        });
    }
}

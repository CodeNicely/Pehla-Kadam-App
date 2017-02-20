package com.example.iket.pehlakadam.imageViewer.presenter;

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
        imagesInterface.showLoading(true);
        imagesProvider.reqImages(new OnImagesReceived() {
            @Override
            public void onFailure() {
                imagesInterface.showLoading(false);
                imagesInterface.showMessage("Try again in some time");
            }

            @Override
            public void onSuccess(List<ImagesData> imagesDataList) {
                imagesInterface.setData(imagesDataList);
                imagesInterface.showLoading(false);
            }
        });
    }
}

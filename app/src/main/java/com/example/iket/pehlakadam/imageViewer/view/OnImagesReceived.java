package com.example.iket.pehlakadam.imageViewer.view;

import com.example.iket.pehlakadam.imageViewer.model.ImagesData;

import java.util.List;

/**
 * Created by Iket on 8/21/2016.
 */
public interface OnImagesReceived {
    void onFailure();
    void onSuccess(List<ImagesData> imagesDataList);
}

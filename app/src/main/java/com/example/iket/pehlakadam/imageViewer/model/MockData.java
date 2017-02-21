package com.example.iket.pehlakadam.imageViewer.model;

import android.util.Log;

import com.example.iket.pehlakadam.imageViewer.view.OnImagesReceived;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iket on 21/2/17.
 */

public class MockData implements ImageProvider {
    ImagesData imagesData;
    @Override
    public ImageList reqImages(OnImagesReceived onImagesReceived) {
        List<ImagesData> imagesDatas=new ArrayList<>();
        for(int i=0;i<5;i++) {
            imagesData = new ImagesData(1, "http://ecellapp.pythonanywhere.com/media/sponsor/oyo.jpg");
            imagesDatas.add(imagesData);
            imagesData=new ImagesData(2,"http://ecellapp.pythonanywhere.com/media/sponsor/benchmark.jpg");
            imagesDatas.add(imagesData);
            imagesData=new ImagesData(2,"https://2.bp.blogspot.com/-9yiv8m0bBhw/VnQSZ01KfiI/AAAAAAAAcLE/_54K6cOmegE/s1600/AndroidRecyclerViewStaggeredGridLayoutManager3.png");
            imagesDatas.add(imagesData);
        }


        Log.d("Response","mock 1");
        ImageList imageList=new ImageList(imagesDatas,true,"");
        Log.d("Response","mock 2");
        onImagesReceived.onSuccess(imageList);
        Log.d("Response","mock 3");
        return imageList;

    }
}

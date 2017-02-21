package com.example.iket.pehlakadam.imageViewer.model;

import com.example.iket.pehlakadam.imageViewer.view.OnImagesReceived;

/**
 * Created by Iket on 8/21/2016.
 */
public interface ImageProvider {
    ImageList reqImages(OnImagesReceived onImagesReceived);
}

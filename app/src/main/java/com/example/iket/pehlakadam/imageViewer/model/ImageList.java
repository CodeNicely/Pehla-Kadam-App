package com.example.iket.pehlakadam.imageViewer.model;

import java.util.List;

/**
 * Created by Iket on 8/21/2016.
 */
public class ImageList {
    private List<ImagesData> images;

    public ImageList(List<ImagesData> images) {
        this.images = images;
    }

    public List<ImagesData> getImages() {
        return images;
    }
}

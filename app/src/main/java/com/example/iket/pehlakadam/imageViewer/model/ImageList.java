package com.example.iket.pehlakadam.imageViewer.model;

import java.util.List;

/**
 * Created by Iket on 8/21/2016.
 */
public class ImageList {
    private List<ImagesData> images;
    private boolean success;
    private String message;

    public ImageList(List<ImagesData> images, boolean success, String message) {
        this.images = images;
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<ImagesData> getImages() {
        return images;
    }
}

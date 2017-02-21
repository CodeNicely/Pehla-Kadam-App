package com.example.iket.pehlakadam.imageViewer.model;

/**
 * Created by Iket on 8/21/2016.
 */
public class ImagesData {
    private String image1;
    private int id;

    public ImagesData(int id,String image1) {
        this.image1 = image1;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getImage1() {
        return image1;
    }

}

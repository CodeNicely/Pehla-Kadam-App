package com.example.iket.pehlakadam.about_us.model.data;

public class AboutUsData {


    private boolean success;
    private String message;
    private String image_url;
    private String title;
    private String description;

    public AboutUsData(boolean success, String message, String image_url, String title, String description) {
        this.success = success;
        this.message = message;
        this.image_url = image_url;
        this.title = title;
        this.description = description;
    }


    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

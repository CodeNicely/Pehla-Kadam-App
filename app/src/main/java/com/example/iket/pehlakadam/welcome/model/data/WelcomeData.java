package com.example.iket.pehlakadam.welcome.model.data;

import java.util.List;


public class WelcomeData {

    private boolean success;
    private String message;
    List<PageDetails> pageDetails;

    public WelcomeData(boolean success, String message, List<PageDetails> pageDetails) {
        this.success = success;
        this.message = message;
        this.pageDetails = pageDetails;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public List<PageDetails> getPageDetails() {
        return pageDetails;
    }
}

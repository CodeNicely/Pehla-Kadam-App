package com.example.iket.pehlakadam.welcome.model.data;


public class PageDetails {

    private String question_id;
    private String question_data;
    private String question_status;

    public PageDetails(String question_id, String question_data, String question_status) {
        this.question_id = question_id;
        this.question_data = question_data;
        this.question_status = question_status;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public String getQuestion_data() {
        return question_data;
    }

    public String getQuestion_status() {
        return question_status;
    }
}

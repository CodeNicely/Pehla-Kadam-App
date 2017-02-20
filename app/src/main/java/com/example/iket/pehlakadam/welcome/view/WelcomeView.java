package com.example.iket.pehlakadam.welcome.view;

import com.example.iket.pehlakadam.welcome.model.data.PageDetails;

import java.util.List;


public interface WelcomeView {

    void showMessage(String error);

    void showProgressBar(boolean show);

    void setData(List<PageDetails> pageDetails);
}

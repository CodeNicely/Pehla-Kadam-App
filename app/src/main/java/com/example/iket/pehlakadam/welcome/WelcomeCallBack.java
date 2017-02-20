package com.example.iket.pehlakadam.welcome;


import com.example.iket.pehlakadam.welcome.model.data.WelcomeData;

public interface WelcomeCallBack {

    void onSuccess(WelcomeData welcomeData);
    void onFailure();
}

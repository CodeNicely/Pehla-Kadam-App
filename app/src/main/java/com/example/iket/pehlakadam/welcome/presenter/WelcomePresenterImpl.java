package com.example.iket.pehlakadam.welcome.presenter;

import android.util.Log;

import com.example.iket.pehlakadam.welcome.WelcomeCallBack;
import com.example.iket.pehlakadam.welcome.model.WelcomeProvider;
import com.example.iket.pehlakadam.welcome.model.data.WelcomeData;
import com.example.iket.pehlakadam.welcome.view.WelcomeView;


public class WelcomePresenterImpl implements WelcomePresenter {


    private WelcomeView welcomeView;
    private WelcomeProvider welcomeProvider;

    public WelcomePresenterImpl(WelcomeView welcomeView, WelcomeProvider welcomeProvider) {
        this.welcomeView = welcomeView;
        this.welcomeProvider = welcomeProvider;
    }

    @Override
    public void requestWelcomeData() {

        welcomeProvider.requestWelcomeData(new WelcomeCallBack() {
            @Override
            public void onSuccess(WelcomeData welcomeData) {
                if(welcomeData.isSuccess())
                {
                    welcomeView.setData(welcomeData.getPageDetails());
                    welcomeView.showMessage("Success");
                    welcomeView.showProgressBar(false);
                }
                else
                {
                    welcomeView.showMessage("Try Again Sometime Later");
                    welcomeView.showProgressBar(false);
                }
            }

            @Override
            public void onFailure() {
                    welcomeView.showMessage("Failed");
            }
        });

    }
}

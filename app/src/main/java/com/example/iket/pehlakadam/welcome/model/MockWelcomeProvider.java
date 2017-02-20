package com.example.iket.pehlakadam.welcome.model;

import android.os.Handler;

import com.example.iket.pehlakadam.welcome.WelcomeCallBack;
import com.example.iket.pehlakadam.welcome.model.data.PageDetails;
import com.example.iket.pehlakadam.welcome.model.data.WelcomeData;

import java.util.ArrayList;
import java.util.List;


public class MockWelcomeProvider implements WelcomeProvider {
    
    @Override
    public void requestWelcomeData(final WelcomeCallBack welcomeCallBack) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                welcomeCallBack.onSuccess(getMockPageDetails());
            }
        },500);

    }

    private WelcomeData getMockPageDetails(){
        List<PageDetails> welcomeDetailsList = new ArrayList<>();

            PageDetails welcomeDetails = new PageDetails
                    ("1","Make your city Proud by keeping it Clean","1");

            welcomeDetailsList.add(welcomeDetails);
            welcomeDetails = new PageDetails
                ("2","Find dustbins nearby you using our app","0");
            welcomeDetailsList.add(welcomeDetails);

        welcomeDetails = new PageDetails
                ("2","Have trouble finding dustbin?\n Request 1 near you","0");
        welcomeDetailsList.add(welcomeDetails);

        welcomeDetails = new PageDetails
                ("2","Lets make our city beautiful \nTOGETHER","0");
        welcomeDetailsList.add(welcomeDetails);




        WelcomeData welcomeData = new WelcomeData(true,"Success",welcomeDetailsList);

        return welcomeData;

    }

}

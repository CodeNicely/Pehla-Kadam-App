package com.example.iket.pehlakadam.about_us.model;

import com.example.iket.pehlakadam.about_us.AboutUsCallBack;
import com.example.iket.pehlakadam.about_us.model.data.AboutUsData;

/**
 * Created by iket on 25/2/17.
 */

public class MockDataAboutUS implements AboutUsProvider {
    @Override
    public void requestAboutUs(AboutUsCallBack aboutUsCallBack) {
        AboutUsData aboutUsData=new AboutUsData(true,"Error","http://rameswaramtourism.com/wp-content/uploads/2015/11/clean-india-campaign-rameswaram.jpg","Pehla Kadam","Pehla Kadam is a non profitable non governmental organisation which aims at keeping our city clean.\nPehla Kadam has provided the city with more than 50 dustbins around the city and has taken several such iniatiatives to ensure that the city is hygienic.\n\nContact:- 9174908579\n email:- clean.india@gmail.com");
        aboutUsCallBack.onSuccess(aboutUsData);
    }

    @Override
    public void onDestroy() {

    }
}

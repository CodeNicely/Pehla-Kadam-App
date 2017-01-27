package com.example.iket.pehlakadam.about_us.model;


import com.example.iket.pehlakadam.about_us.AboutUsCallBack;

public interface AboutUsProvider {


    void requestAboutUs(AboutUsCallBack aboutUsCallBack);
    void onDestroy();

}

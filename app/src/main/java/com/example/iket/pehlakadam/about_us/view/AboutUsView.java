package com.example.iket.pehlakadam.about_us.view;

import com.example.iket.pehlakadam.about_us.model.data.AboutUsData;

public interface AboutUsView {


    void showMessage(String message);
    void showLoader(boolean show);
    void setData(AboutUsData aboutUsData);
}

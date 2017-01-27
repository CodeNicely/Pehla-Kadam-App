package com.example.iket.pehlakadam.about_us.presenter;


import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.about_us.AboutUsCallBack;
import com.example.iket.pehlakadam.about_us.model.AboutUsProvider;
import com.example.iket.pehlakadam.about_us.model.data.AboutUsData;
import com.example.iket.pehlakadam.about_us.view.AboutUsView;
import com.example.iket.pehlakadam.helper.MyApplication;

/**
 * Created by meghal on 13/10/16.
 */

public class AboutUsPresenterImpl implements AboutUsPresenter{


    private AboutUsView aboutUsView;
    private AboutUsProvider aboutUsProvider;

    public AboutUsPresenterImpl(AboutUsView aboutUsView, AboutUsProvider aboutUsProvider) {
        this.aboutUsView = aboutUsView;
        this.aboutUsProvider = aboutUsProvider;
    }

    @Override
    public void requestAboutUs() {

        aboutUsView.showLoader(true);
        aboutUsProvider.requestAboutUs(new AboutUsCallBack() {
            @Override
            public void onSuccess(AboutUsData aboutUsData) {

                aboutUsView.showLoader(false);
                if(aboutUsData.isSuccess()){

                    aboutUsView.setData(aboutUsData);

                }else{
                    aboutUsView.showMessage(aboutUsData.getMessage());
                }
            }
            @Override
            public void onFailure() {

                aboutUsView.showLoader(false);
                aboutUsView.showMessage("No internet connection");

            }
        });

    }

    @Override
    public void onDestroy() {
        aboutUsProvider.onDestroy();
    }
}

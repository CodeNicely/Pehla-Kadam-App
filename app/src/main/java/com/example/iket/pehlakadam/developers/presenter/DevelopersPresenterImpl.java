package com.example.iket.pehlakadam.developers.presenter;


import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.developers.DevelopersCallback;
import com.example.iket.pehlakadam.developers.model.DeveloperProvider;
import com.example.iket.pehlakadam.developers.model.data.DeveloperData;
import com.example.iket.pehlakadam.developers.view.DeveloperView;
import com.example.iket.pehlakadam.helper.MyApplication;

public class DevelopersPresenterImpl implements DevelopersPresenter{

    private DeveloperView developerView;
    private DeveloperProvider developerProvider;

    public DevelopersPresenterImpl(DeveloperView developerView, DeveloperProvider developerProvider) {
        this.developerView = developerView;
        this.developerProvider = developerProvider;
    }

    @Override
    public void requestDevelopersData() {

        developerView.showLoading(true);
        developerProvider.requestDevelopersData(new DevelopersCallback() {
            @Override
            public void onSuccess(DeveloperData developerData) {

                developerView.showLoading(false);
                if(developerData.isSuccess()){
                    developerView.setData(developerData.getCompanyData());
                }else {
                    developerView.showMessage(developerData.getMessage());
                }

            }

            @Override
            public void onFailed() {

                developerView.showLoading(false);
                developerView.showMessage(MyApplication.getContext().getResources().getString(R.string.failure_message));
            }
        });



    }

    @Override
    public void onDestroy() {
        developerProvider.onDestroy();
    }
}

package com.example.iket.pehlakadam.join_us.presenter;


import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.helper.MyApplication;
import com.example.iket.pehlakadam.join_us.JoinUsCallback;
import com.example.iket.pehlakadam.join_us.model.JoinUsProvider;
import com.example.iket.pehlakadam.join_us.model.data.JoinUsData;
import com.example.iket.pehlakadam.join_us.view.JoinUsView;

/**
 * Created by meghal on 12/10/16.
 */

public class JoinUsPresenterImpl implements JoinUsPresenter {

    private JoinUsView joinUsView;
    private JoinUsProvider joinUsProvider;

    public JoinUsPresenterImpl(JoinUsView joinUsView, JoinUsProvider joinUsProvider) {
        this.joinUsView = joinUsView;
        this.joinUsProvider = joinUsProvider;
    }

    @Override
    public void requestJoin(String name, String mobile, String email) {

        joinUsView.showLoading(true);
        joinUsProvider.requestJoin(name, mobile, email, new JoinUsCallback() {
            @Override
            public void onSuccess(JoinUsData joinUsData) {

                joinUsView.showLoading(false);
                if(joinUsData.isSuccess()){
//                    joinUsView.showMessage(joinUsData.getMessage());
                    joinUsView.showDialog("Successfully Submitted","We have received your request and we will be contacting you soon.Thanks :)");
                }else{
                    joinUsView.showMessage(joinUsData.getMessage());
                }


            }

            @Override
            public void onFailure() {

                joinUsView.showLoading(false);
                joinUsView.showMessage(MyApplication.getContext().getResources().getString(R.string.failure_message));
            }
        });



    }
}

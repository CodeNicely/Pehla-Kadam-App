package com.example.iket.pehlakadam.contact_us.presenter;

import com.example.iket.pehlakadam.contact_us.ContactUsCallback;
import com.example.iket.pehlakadam.contact_us.model.ContactUsProvider;
import com.example.iket.pehlakadam.contact_us.model.data.ContactUsData;
import com.example.iket.pehlakadam.contact_us.view.ContactUsView;

/**
 * Created by meghal on 15/10/16.
 */

public class ContactUsPresenterImpl implements ContactUsPresenter {

    private ContactUsView contactUsView;
    private ContactUsProvider contactUsProvider;

    public ContactUsPresenterImpl(ContactUsView contactUsView, ContactUsProvider contactUsProvider) {
        this.contactUsView = contactUsView;
        this.contactUsProvider = contactUsProvider;
    }

    @Override
    public void requestContactUs() {

        contactUsView.showLoader(true);
        contactUsProvider.requestContactUs(new ContactUsCallback() {
            @Override
            public void onSuccess(ContactUsData contactUsData) {

                contactUsView.showLoader(false);
                if(contactUsData.isSuccess()){
                    contactUsView.setData(contactUsData);
//                    contactUsView.showMessage(contactUsData.getMessage());
                }else
                {
                    contactUsView.showMessage(contactUsData.getMessage());
                }
            }

            @Override
            public void onFailure() {

                contactUsView.showLoader(false);
                contactUsView.showMessage("Check your internet connection");
            }
        });

    }

    @Override
    public void onDestroy() {
        contactUsProvider.onDestroy();
    }
}

package com.example.iket.pehlakadam.join_us;


import com.example.iket.pehlakadam.join_us.model.data.JoinUsData;

/**
 * Created by meghal on 12/10/16.
 */

public interface JoinUsCallback {

    void onSuccess(JoinUsData joinUsData);
    void onFailure();


}

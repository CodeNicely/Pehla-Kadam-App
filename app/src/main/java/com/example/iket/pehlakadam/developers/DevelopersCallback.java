package com.example.iket.pehlakadam.developers;


import com.example.iket.pehlakadam.developers.model.data.DeveloperData;

/**
 * Created by meghal on 17/10/16.
 */

public interface DevelopersCallback {

    void onSuccess(DeveloperData developerData);
    void onFailed();


}

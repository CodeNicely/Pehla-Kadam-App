package com.example.iket.pehlakadam.developers.model;


import com.example.iket.pehlakadam.developers.DevelopersCallback;

/**
 * Created by meghal on 17/10/16.
 */

public interface DeveloperProvider {

    void requestDevelopersData(DevelopersCallback developersCallback);
    void onDestroy();
}

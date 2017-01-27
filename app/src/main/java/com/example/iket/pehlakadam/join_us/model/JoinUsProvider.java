package com.example.iket.pehlakadam.join_us.model;

import com.example.iket.pehlakadam.join_us.JoinUsCallback;

/**
 * Created by meghal on 12/10/16.
 */

public interface JoinUsProvider {



    void requestJoin(String name, String mobile, String email, JoinUsCallback joinUsCallback);


}

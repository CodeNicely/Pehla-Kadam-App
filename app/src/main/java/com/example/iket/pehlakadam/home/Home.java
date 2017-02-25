package com.example.iket.pehlakadam.home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.iket.pehlakadam.R;

public class Home extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewpager=(ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewpager);
    }
}

package com.example.iket.pehlakadam.home;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.helper.SharedPrefs;


public class Home extends AppCompatActivity {

    private SharedPrefs sharedPrefs;
    private ViewPager viewpager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sharedPrefs=new SharedPrefs(this);
        sharedPrefs.setFirstTimeLaunch(false);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewpager=(ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewpager);
    }

}

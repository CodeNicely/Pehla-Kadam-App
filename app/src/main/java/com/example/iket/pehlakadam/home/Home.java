package com.example.iket.pehlakadam.home;

import android.content.Intent;
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
import com.example.iket.pehlakadam.gallery.model.data.ContentDetails;
import com.example.iket.pehlakadam.helper.Keys;
import com.example.iket.pehlakadam.helper.SharedPrefs;
import com.example.iket.pehlakadam.image_viewer.ImageViewerActivity;
import com.example.iket.pehlakadam.video_player.VideoPlayer;

import java.util.ArrayList;
import java.util.List;


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

    public void playVideo(String video_url) {
        Log.d("res","2");
        Intent vid=new Intent(Home.this, VideoPlayer.class);
        vid.putExtra("url",video_url);
        startActivity(vid);
    }

    public void showImage(List<ContentDetails> contentDetailses, int position) {
        ArrayList<String> imageUrlList=new ArrayList<>();
        for ( int i=0;i<contentDetailses.size();i++){
            if(contentDetailses.get(i).getType()==1)
            imageUrlList.add(contentDetailses.get(i).getImage_url());
        }
        Intent image_viewer=new Intent(Home.this, ImageViewerActivity.class);

        image_viewer.putStringArrayListExtra("list", imageUrlList);
        image_viewer.putExtra("position", position);
        startActivity(image_viewer);
    }
}

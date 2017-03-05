package com.example.iket.pehlakadam.home;

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
import com.joaquimley.faboptions.FabOptions;

public class Home extends AppCompatActivity {

    private SharedPrefs sharedPrefs;
    private ViewPager viewpager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final FabOptions fabOptions = (FabOptions) findViewById(R.id.fab_options);




        sharedPrefs=new SharedPrefs(this);
        sharedPrefs.setFirstTimeLaunch(false);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewpager=(ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_float, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.faboptions_favorite:
                Log.d("Res","1");
                Toast.makeText(this, "Favourite", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.faboptions_share:
                Log.d("Res","1");
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.faboptions_download:
                Log.d("Res","1");
                Toast.makeText(this, "Download", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.faboptions_textsms:
                Log.d("Res","1");
                Toast.makeText(this, "Text", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

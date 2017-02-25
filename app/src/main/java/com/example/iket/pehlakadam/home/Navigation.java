package com.example.iket.pehlakadam.home;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.iket.pehlakadam.R;
import com.example.iket.pehlakadam.about_us.view.AboutUsFragment;
import com.example.iket.pehlakadam.contact_us.view.ContactUsFragment;
import com.example.iket.pehlakadam.gallery.view.GalleryFragment;
import com.example.iket.pehlakadam.geotag.Geotag;
import com.example.iket.pehlakadam.helper.SharedPrefs;
import com.example.iket.pehlakadam.imageViewer.view.ImagesFragment;
import com.example.iket.pehlakadam.join_us.view.JoinUsFragment;
import com.example.iket.pehlakadam.language.LanguageFragment;
import com.example.iket.pehlakadam.video_player.VidPlayer;
import com.example.iket.pehlakadam.welcome.view.WelcomeFragment;

import java.io.PrintStream;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

private SharedPrefs sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        sharedPrefs=new SharedPrefs(this);
        if(sharedPrefs.isFirstTimeLaunch()) {
            getSupportActionBar().hide();
            setFragment(new WelcomeFragment(), "");
        }
        else
        {
           setHome();
        }

    }

    public void setHome() {
        getSupportActionBar().show();
        addFragment(new HomeFragment(), "Home");
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if(id==R.id.nav_home){
            setHome();
        } else if (id == R.id.nav_language) {
            setFragment(new LanguageFragment(),"Language");
        } else if (id == R.id.nav_geotag) {
            setFragment(new Geotag(),"GeoDustbin");
        } else if (id == R.id.nav_images) {
            setFragment(new ImagesFragment(),"Gallery");
        }else if (id == R.id.nav_video) {
            setFragment(new VidPlayer(),"Videos");
        }
        else if (id == R.id.nav_join_us) {
            setFragment(new JoinUsFragment(),"Join Us");
        } else if (id == R.id.nav_about_us) {
            setFragment(new AboutUsFragment(),"About us");
        } else if (id == R.id.nav_contact_us) {
            setFragment(new ContactUsFragment(),"Contact us");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setFragment(Fragment fragment, String title) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home_layout, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }
    }
    public void addFragment(Fragment fragment, String title) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home_layout, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }
    }
}

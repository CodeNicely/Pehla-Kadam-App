package com.example.iket.pehlakadam.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.iket.pehlakadam.about_us.view.AboutUsFragment;
import com.example.iket.pehlakadam.gallery.view.GalleryFragment;
import com.example.iket.pehlakadam.geotag.Geotag;
import com.example.iket.pehlakadam.reviews.view.ReviewsFragment;

class ViewPagerAdapter extends FragmentPagerAdapter {

    final int TAB_COUNT = 5;
    private String tabTitles[] = new String[]{"Post","Find Bins","Gallery","Reviews","About Us"};

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            ;
        else if(position==1)
            return Geotag.newInstance("Hello","bhailog");
        else if (position==2)
            return GalleryFragment.newInstance("dfdf","gdfg");
        else if(position==3)
            return ReviewsFragment.newInstance("sdvfv","dfvdv");
        else if(position==4)
            return AboutUsFragment.newInstance("efvv","efvefv");

        return TabsFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
   }

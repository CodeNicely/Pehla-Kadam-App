package com.example.iket.pehlakadam.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.iket.pehlakadam.gallery.view.GalleryFragment;
import com.example.iket.pehlakadam.geotag.Geotag;

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
        if(position==1)
            return Geotag.newInstance("Hello","bhailog");
        else if (position==2)
            return GalleryFragment.newInstance("dfdf","gdfg");
        else
        return TabsFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
   }

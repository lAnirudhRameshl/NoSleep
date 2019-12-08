package com.example.android.nosleep;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class NoSleepFragmenPagerAdapter extends FragmentPagerAdapter {

    public NoSleepFragmenPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
            return new TopActvity();
        else
            return new NewActivity();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return "TOP";
        else
            return "NEW";
    }
}

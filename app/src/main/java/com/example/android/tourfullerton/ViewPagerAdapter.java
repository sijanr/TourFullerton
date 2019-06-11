package com.example.android.tourfullerton;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final int TOTAL_PAGE = 2;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new FirstBarFragment();

            case 1:
                return new SecondBarFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TOTAL_PAGE;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "THE BLUE DOOR BAR";
            case 1:
                return "TRIBUNE";
            default:
                return "Null";
        }
    }
}

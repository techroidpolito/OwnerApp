package com.gratus.ownerapp.adapter;

import android.content.Context;

import com.gratus.ownerapp.activity.OrderActivity;
import com.gratus.ownerapp.fragment.BreakfastOrderFragment;
import com.gratus.ownerapp.fragment.DinnerOrderFragment;
import com.gratus.ownerapp.fragment.LunchOrderFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class OrdersPagerAdapter extends FragmentPagerAdapter {
    public OrdersPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = BreakfastOrderFragment.newInstance();
                break;
            case 1:
                fragment = LunchOrderFragment.newInstance();
                break;
            case 2:
                fragment = DinnerOrderFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Breakfast";
            case 1:
                return "Lunch";
            case 2:
                return "Dinner";
        }
        return null;
    }
}
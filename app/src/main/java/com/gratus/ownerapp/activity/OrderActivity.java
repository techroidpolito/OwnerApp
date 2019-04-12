package com.gratus.ownerapp.activity;

import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;
import com.gratus.ownerapp.R;
import com.gratus.ownerapp.adapter.CustomViewPager;
import com.gratus.ownerapp.adapter.OrdersPagerAdapter;


import androidx.appcompat.app.AppCompatActivity;


public class OrderActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;
    private CustomViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().hide();
        }
     /*   if(savedInstanceState!=null){
            viewPager = (CustomViewPager) findViewById(R.id.viewpager);
            viewPager.setPagingEnabled(true);
            viewPager.setOffscreenPageLimit(3);
            tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);
            OrdersPagerAdapter adapter = new OrdersPagerAdapter(getSupportFragmentManager());
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        }
        else {*/
            viewPager = (CustomViewPager) findViewById(R.id.viewpager);
            viewPager.setPagingEnabled(true);
            viewPager.setOffscreenPageLimit(3);
            tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);
            OrdersPagerAdapter adapter = new OrdersPagerAdapter(getSupportFragmentManager());
            viewPager.setAdapter(adapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    //    }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

}

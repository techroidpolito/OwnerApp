package com.gratus.ownerapp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;


import com.gratus.ownerapp.R;
import com.gratus.ownerapp.adapter.DashboardAdapter;
import com.gratus.ownerapp.model.DashboardAdapterModel;
import com.gratus.ownerapp.util.interfaces.OnItemClickListener;

import java.util.ArrayList;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DashboardActivity extends AppCompatActivity implements OnItemClickListener {
    private int MENU = 1;
    private int OFFER = 2;
    private int ORDER = 3;
    private int PROFILE = 4;
    private ActionBar toolbar;
    private RecyclerView userRecyclerView;
    private DashboardAdapter mAdapter;
    private ArrayList<DashboardAdapterModel> dashboardAdapterModel = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;
    @SuppressLint("ResourceAsColor")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        toolbar = getSupportActionBar();
        toolbar.setTitle(getResources().getString(R.string.app_name));
        userRecyclerView = findViewById(R.id.userRecyclerView);
        setAdapter();
    }

    private void setAdapter() {
        dashboardAdapterModel.add(new DashboardAdapterModel(MENU,R.color.purple_300,R.drawable.menu_icon,"Add/Edit menu"));
        dashboardAdapterModel.add(new DashboardAdapterModel(OFFER,R.color.light_blue_300,R.drawable.promo_icon,"Add/Edit offer"));
        dashboardAdapterModel.add(new DashboardAdapterModel(ORDER,R.color.indigo_300,R.drawable.order_list,"# of orders"));
        dashboardAdapterModel.add(new DashboardAdapterModel(PROFILE,R.color.blue_300,R.drawable.profile_icon,"Profile"));
        mLayoutManager = new GridLayoutManager(DashboardActivity.this,2);
        mAdapter = new DashboardAdapter(dashboardAdapterModel);
        userRecyclerView.setLayoutManager(mLayoutManager);
        userRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnItemClickListener(DashboardActivity.this);
    }

    @Override
    public void onItemClick(int position) {
        if(dashboardAdapterModel.get(position).getLayoutType()==PROFILE){
            Intent i = new Intent(DashboardActivity.this, UserProfileNoEditActivity.class);
            startActivity(i);
        }
        if(dashboardAdapterModel.get(position).getLayoutType()==ORDER){
            Intent i = new Intent(DashboardActivity.this, OrderActivity.class);
            startActivity(i);
        }
        if(dashboardAdapterModel.get(position).getLayoutType()==MENU){
            Intent i = new Intent(DashboardActivity.this, MenuOfferActivity.class);
            startActivity(i);
        }
        if(dashboardAdapterModel.get(position).getLayoutType()==OFFER){
            Intent i = new Intent(DashboardActivity.this, MenuOfferActivity.class);
            startActivity(i);
        }
    }
}

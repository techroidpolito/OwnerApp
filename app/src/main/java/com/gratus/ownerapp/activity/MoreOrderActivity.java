package com.gratus.ownerapp.activity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gratus.ownerapp.R;
import com.gratus.ownerapp.adapter.MoreOrderAdapter;
import com.gratus.ownerapp.model.NoofOrderAdapterModel;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MoreOrderActivity extends AppCompatActivity {
    private int DETAILS = 1;
    private int ADDRESS = 2;
    private int ITEM = 3;
    private RecyclerView orderitemsRV;
    private TextView accrejTv;
    private Button acceptBt,rejectBt;
    private MoreOrderAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<NoofOrderAdapterModel> noofOrderAdapterModelArrayList = new ArrayList<>();
    private NoofOrderAdapterModel noofOrderAdapterModelArrayLists;
    public static final int REQUEST_CODE = 1;
    public static final int REJECT_CODE = 2;
    Intent intent;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_order);
        orderitemsRV = findViewById(R.id.orderitemsRV);
        acceptBt = findViewById(R.id.acceptBt);
        rejectBt = findViewById(R.id.rejectBt);
        accrejTv = findViewById(R.id.accrejTv);
        if (savedInstanceState != null) {
            savedInstanceState.getSerializable("mod");
        }
        if(getIntent().getSerializableExtra("ordermodel")!=null){
            noofOrderAdapterModelArrayLists = (NoofOrderAdapterModel) getIntent().getSerializableExtra("ordermodel");
            noofOrderAdapterModelArrayList = new ArrayList<>();
                noofOrderAdapterModelArrayList.add(new NoofOrderAdapterModel(DETAILS, noofOrderAdapterModelArrayLists.getUserName(),noofOrderAdapterModelArrayLists.getTimeOrder(),
                        noofOrderAdapterModelArrayLists.getNoItems(),noofOrderAdapterModelArrayLists.getTotalAmt(),noofOrderAdapterModelArrayLists.getPaymentType(),
                        noofOrderAdapterModelArrayLists.getAccept(),noofOrderAdapterModelArrayLists.getReject(),noofOrderAdapterModelArrayLists.getOrderNo()));
                noofOrderAdapterModelArrayList.add(new NoofOrderAdapterModel(ADDRESS, getResources().getString(R.string.address),"via Mompellato 34 , Torino 10119"));
                noofOrderAdapterModelArrayList.add(new NoofOrderAdapterModel(ITEM,"1","Kebab",""));
                noofOrderAdapterModelArrayList.add(new NoofOrderAdapterModel(ITEM,"2","Pizza","Make it more spicy"));
            if(noofOrderAdapterModelArrayLists.getAccept()==false && noofOrderAdapterModelArrayLists.getReject()==false){
                acceptBt.setVisibility(View.VISIBLE);
                rejectBt.setVisibility(View.VISIBLE);
                accrejTv.setVisibility(View.GONE);
            }
            if(noofOrderAdapterModelArrayLists.getAccept()==true && noofOrderAdapterModelArrayLists.getReject()==false){
                acceptBt.setVisibility(View.GONE);
                rejectBt.setVisibility(View.GONE);
                accrejTv.setVisibility(View.VISIBLE);
                accrejTv.setText("Order is successfully accepted");
                accrejTv.setTextColor(ContextCompat.getColor(MoreOrderActivity.this, R.color.green_800));
            }
            if(noofOrderAdapterModelArrayLists.getAccept()==false && noofOrderAdapterModelArrayLists.getReject()==true){
                acceptBt.setVisibility(View.GONE);
                rejectBt.setVisibility(View.GONE);
                accrejTv.setVisibility(View.VISIBLE);
                accrejTv.setText("Order is rejected");
                accrejTv.setTextColor(ContextCompat.getColor(MoreOrderActivity.this, R.color.red_800));
            }
            setAdapter();
            acceptBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("position", getIntent().getIntExtra("position",0));
                    intent.putExtra("accept_reject", 1);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
            rejectBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MoreOrderActivity.this, OrderRejectionActivity.class);
                    intent.putExtra("ordermodel",  noofOrderAdapterModelArrayLists);
                    intent.putExtra("position",  getIntent().getIntExtra("position",0));
                    startActivityForResult(intent, REJECT_CODE);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            });

        }
    }

    private void setAdapter() {
        mLayoutManager = new LinearLayoutManager(MoreOrderActivity.this);
        mAdapter = new MoreOrderAdapter(noofOrderAdapterModelArrayList,MoreOrderActivity.this);
        orderitemsRV.setLayoutManager(mLayoutManager);
        orderitemsRV.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("mod", noofOrderAdapterModelArrayList);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        noofOrderAdapterModelArrayList = (ArrayList<NoofOrderAdapterModel>) savedInstanceState.getSerializable("mod");
        if(noofOrderAdapterModelArrayList!=null&& noofOrderAdapterModelArrayList.size()>0) {
            setAdapter();
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REJECT_CODE) {

            if (resultCode == Activity.RESULT_OK) {
                Intent intent = new Intent();
                intent.putExtra("position", getIntent().getIntExtra("position",0));
                intent.putExtra("accept_reject", 0);
                setResult(RESULT_OK, intent);
                finish();
            } else if (resultCode == Activity.RESULT_CANCELED) {
                setAdapter();
            }
        }
    }
}

package com.gratus.ownerapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gratus.ownerapp.R;
import com.gratus.ownerapp.adapter.OrderRejectionAdapter;
import com.gratus.ownerapp.model.NoofOrderAdapterModel;
import com.gratus.ownerapp.model.RejectionAdapterModel;
import com.gratus.ownerapp.util.interfaces.RejectMoreClickItemListerner;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrderRejectionActivity extends AppCompatActivity implements RejectMoreClickItemListerner {
    private RecyclerView rejectionRV;
    private EditText sDesEt;
    private Button sendBt;
    private OrderRejectionAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<RejectionAdapterModel> rejectionAdapterModels = new ArrayList<>();
    private ArrayList<String> selectedoptions = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejection);
        rejectionRV = findViewById(R.id.rejectionRV);
        sendBt = findViewById(R.id.sendBt);
        sDesEt = findViewById(R.id.sDesEt);
        if (savedInstanceState != null) {
            savedInstanceState.getSerializable("mod");
        }
        else{
            setAdapterItem();
        }
        sendBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<rejectionAdapterModels.size();i++){
                    if(rejectionAdapterModels.get(i).getSelected()==true){
                        selectedoptions.add(rejectionAdapterModels.get(i).getReason());
                    }
                }
                if(selectedoptions.size()>0||!sDesEt.getText().toString().isEmpty()) {
                    Intent intent = new Intent();
                    intent.putExtra("position", getIntent().getIntExtra("position", 0));
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else{
                    Toast.makeText(OrderRejectionActivity.this,"Please any one of the option or give reason for rejection of order or both", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void setAdapterItem() {
        rejectionAdapterModels.add(new RejectionAdapterModel("Option1",false));
        rejectionAdapterModels.add(new RejectionAdapterModel("Option2",false));
        rejectionAdapterModels.add(new RejectionAdapterModel("Option3",false));
        rejectionAdapterModels.add(new RejectionAdapterModel("Option4",false));
        rejectionAdapterModels.add(new RejectionAdapterModel("Option5",false));
        setAdapter();
    }

    private void setAdapter() {
        mLayoutManager = new LinearLayoutManager(OrderRejectionActivity.this);
        mAdapter = new OrderRejectionAdapter(rejectionAdapterModels,OrderRejectionActivity.this);
        rejectionRV.setLayoutManager(mLayoutManager);
        rejectionRV.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mAdapter.setOrderMoreClickItemListerner(OrderRejectionActivity.this);
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("mod", rejectionAdapterModels);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        rejectionAdapterModels = (ArrayList<RejectionAdapterModel>) savedInstanceState.getSerializable("mod");
        if(rejectionAdapterModels!=null&& rejectionAdapterModels.size()>0) {
            setAdapter();
        }

    }

    @Override
    public void onRejectClick(int position) {
        if(rejectionAdapterModels.get(position).getSelected()==false) {
            rejectionAdapterModels.get(position).setSelected(true);
            mAdapter.notifyItemChanged(position);
        }
        else{
            rejectionAdapterModels.get(position).setSelected(false);
            mAdapter.notifyItemChanged(position);
        }
    }
}

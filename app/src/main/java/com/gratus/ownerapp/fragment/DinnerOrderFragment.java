package com.gratus.ownerapp.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.gratus.ownerapp.R;
import com.gratus.ownerapp.activity.MoreOrderActivity;
import com.gratus.ownerapp.activity.OrderRejectionActivity;
import com.gratus.ownerapp.adapter.NoofOrderAdapter;
import com.gratus.ownerapp.model.NoofOrderAdapterModel;
import com.gratus.ownerapp.util.interfaces.AcceptMoreClickItemListerner;
import com.gratus.ownerapp.util.interfaces.OrderMoreClickItemListerner;
import com.gratus.ownerapp.util.interfaces.RejectMoreClickItemListerner;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DinnerOrderFragment extends Fragment implements AcceptMoreClickItemListerner, OrderMoreClickItemListerner, RejectMoreClickItemListerner {

    private RelativeLayout exceptionRl;
    private RecyclerView dinnerRecyclerView;
    private NoofOrderAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<NoofOrderAdapterModel> noofOrderAdapterModel = new ArrayList<>();
    public static final int ACCEPT_CODE = 1;
    public static final int REJECT_CODE = 2;
    public static final int ACCEPT_REJECT_CODE = 3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dinner,container,false);
        exceptionRl = view.findViewById(R.id.exceptionRl);
        dinnerRecyclerView = view.findViewById(R.id.dinnerRecyclerView);
       /* if(userProfileRegistrationModels!=null && userProfileRegistrationModels.size()==0){
            exceptionRl.setVisibility(View.VISIBLE);
            breakfastRecyclerView.setVisibility(View.GONE);
        }
        else{
            exceptionRl.setVisibility(View.GONE);
            breakfastRecyclerView.setVisibility(View.VISIBLE);
        }*/
        if (savedInstanceState != null) {
            noofOrderAdapterModel = (ArrayList<NoofOrderAdapterModel>) savedInstanceState.getSerializable("breakfast");
            if (noofOrderAdapterModel != null && noofOrderAdapterModel.size() > 0) {
                setAdapter();
            }
            else{
                exceptionRl.setVisibility(View.VISIBLE);
                dinnerRecyclerView.setVisibility(View.GONE);
            }
        }
        else {
            setAdapterItem();
        }
        return view;
    }

    private void setAdapterItem() {
     /*   noofOrderAdapterModel = new ArrayList<>();
        noofOrderAdapterModel.add(new NoofOrderAdapterModel("Gratus","12:30pm","1","100","Online",false,false,"0001"));
        noofOrderAdapterModel.add(new NoofOrderAdapterModel("Jijo","12:30pm","3","200","Online",false,false,"0002"));
        noofOrderAdapterModel.add(new NoofOrderAdapterModel("Louis","12:30pm","5","450","Online",true,false,"0003"));
        noofOrderAdapterModel.add(new NoofOrderAdapterModel("Eliza","12:30pm","7","1000","Online",false,true,"0004"));
     */ if (noofOrderAdapterModel != null && noofOrderAdapterModel.size() > 0) {
            setAdapter();
        }
        else{
            exceptionRl.setVisibility(View.VISIBLE);
            dinnerRecyclerView.setVisibility(View.GONE);
        }
    }

    private void setAdapter() {
        exceptionRl.setVisibility(View.GONE);
        dinnerRecyclerView.setVisibility(View.VISIBLE);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new NoofOrderAdapter(noofOrderAdapterModel,getActivity());
        dinnerRecyclerView.setLayoutManager(mLayoutManager);
        dinnerRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mAdapter.setAcceptMoreClickItemListerner(DinnerOrderFragment.this);
        mAdapter.setOrderMoreClickItemListerner(DinnerOrderFragment.this);
        mAdapter.setRejectMoreClickItemListerner(DinnerOrderFragment.this);
    }


    public static DinnerOrderFragment  newInstance() {
        DinnerOrderFragment frag = new DinnerOrderFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return(frag);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("dinner", noofOrderAdapterModel);
    }

    @Override
    public void onAcceptClick(int position) {
        noofOrderAdapterModel.get(position).setAccept(true);
        mAdapter.notifyItemChanged(position);
    }
    @Override
    public void onMoreClick(int position) {
        Intent intent = new Intent(getActivity(), MoreOrderActivity.class);
        intent.putExtra("ordermodel",  noofOrderAdapterModel.get(position));
        intent.putExtra("position",  position);
        startActivityForResult(intent, ACCEPT_CODE);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void onRejectClick(int position) {
        Intent intent = new Intent(getActivity(), OrderRejectionActivity.class);
        intent.putExtra("ordermodel",  noofOrderAdapterModel.get(position));
        intent.putExtra("position",  position);
        startActivityForResult(intent, REJECT_CODE);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == ACCEPT_CODE) {

            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getExtras();
                int position = bundle.getInt("position",0);
                noofOrderAdapterModel.get(position).setAccept(true);
                mAdapter.notifyItemChanged(position);

            } else if (resultCode == Activity.RESULT_CANCELED) {
                //setAdapterItem();
            }
        }
        if (requestCode == REJECT_CODE) {

            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getExtras();
                int position = bundle.getInt("position",0);
                noofOrderAdapterModel.get(position).setReject(true);
                mAdapter.notifyItemChanged(position);

            } else if (resultCode == Activity.RESULT_CANCELED) {
                // setAdapterItem();
            }
        }
        if (requestCode == ACCEPT_REJECT_CODE) {

            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle = data.getExtras();
                int position = bundle.getInt("position",0);
                int accept_reject = bundle.getInt("accept_reject",0);
                if(accept_reject==1) {
                    noofOrderAdapterModel.get(position).setAccept(true);
                    mAdapter.notifyItemChanged(position);
                }
                else{
                    noofOrderAdapterModel.get(position).setReject(true);
                    mAdapter.notifyItemChanged(position);
                }

            } else if (resultCode == Activity.RESULT_CANCELED) {
                // setAdapterItem();
            }
        }
    }
}
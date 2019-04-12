package com.gratus.ownerapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gratus.ownerapp.R;
import com.gratus.ownerapp.model.NoofOrderAdapterModel;
import com.gratus.ownerapp.util.interfaces.AcceptMoreClickItemListerner;
import com.gratus.ownerapp.util.interfaces.OrderMoreClickItemListerner;
import com.gratus.ownerapp.util.interfaces.RejectMoreClickItemListerner;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class NoofOrderAdapter extends RecyclerView.Adapter {
    private ArrayList<NoofOrderAdapterModel> noofOrderAdapterModel = new ArrayList<>();
    Context context;
    private OrderItemViewHolder orderItemViewHolder;
    private OrderMoreClickItemListerner orderMoreClickItemListerner;
    private AcceptMoreClickItemListerner acceptMoreClickItemListerner;
    private RejectMoreClickItemListerner rejectMoreClickItemListerner;
    public NoofOrderAdapter(ArrayList<NoofOrderAdapterModel> noofOrderAdapterModel, Context context) {
        this.noofOrderAdapterModel = noofOrderAdapterModel;
        this.context =context;
    }
    public void setOrderMoreClickItemListerner(OrderMoreClickItemListerner listener) {
        orderMoreClickItemListerner = listener;
    }
    public void setAcceptMoreClickItemListerner(AcceptMoreClickItemListerner listener) {
        acceptMoreClickItemListerner = listener;
    }
    public void setRejectMoreClickItemListerner(RejectMoreClickItemListerner listener) {
        rejectMoreClickItemListerner = listener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate( R.layout.fragment_orders_item, null);
        return new NoofOrderAdapter.OrderItemViewHolder(itemView);
    }

    public class OrderItemViewHolder extends RecyclerView.ViewHolder {
        TextView usernameTv,orderNoTv,timeTv,noitem_placedtv,cash_placedtv,type_placedtv,movetv,accrejTv;
        Button acceptBt,rejectBt;
        public OrderItemViewHolder(View itemView) {
            super(itemView);
            usernameTv = itemView.findViewById(R.id.usernameTv);
            orderNoTv = itemView.findViewById(R.id.orderNoTv);
            timeTv =  itemView.findViewById(R.id.timeTv);
            noitem_placedtv =  itemView.findViewById(R.id.noitem_placedtv);
            cash_placedtv =  itemView.findViewById(R.id.cash_placedtv);
            type_placedtv =  itemView.findViewById(R.id.type_placedtv);
            movetv =  itemView.findViewById(R.id.movetv);
            accrejTv =  itemView.findViewById(R.id.accrejTv);
            acceptBt =  itemView.findViewById(R.id.acceptBt);
            rejectBt =  itemView.findViewById(R.id.rejectBt);
            acceptBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (acceptMoreClickItemListerner != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            acceptMoreClickItemListerner.onAcceptClick(position);
                        }
                    }
                }
            });
            rejectBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (rejectMoreClickItemListerner != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            rejectMoreClickItemListerner.onRejectClick(position);
                        }
                    }
                }
            });
            movetv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (orderMoreClickItemListerner != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            orderMoreClickItemListerner.onMoreClick(position);
                        }
                    }
                }
            });
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NoofOrderAdapterModel noofOrderAdapterModels = noofOrderAdapterModel.get(position);
        orderItemViewHolder = (OrderItemViewHolder) holder;
        if(noofOrderAdapterModels.getOrderNo()!=null &&!noofOrderAdapterModels.getOrderNo().isEmpty()){
            orderItemViewHolder.orderNoTv.setText(noofOrderAdapterModels.getOrderNo());
        }
        if(noofOrderAdapterModels.getTimeOrder()!=null &&!noofOrderAdapterModels.getTimeOrder().isEmpty()){
            orderItemViewHolder.timeTv.setText(noofOrderAdapterModels.getTimeOrder());
        }
        if(noofOrderAdapterModels.getNoItems()!=null &&!noofOrderAdapterModels.getNoItems().isEmpty()){
            orderItemViewHolder.noitem_placedtv.setText(noofOrderAdapterModels.getNoItems());
        }
        if(noofOrderAdapterModels.getTotalAmt()!=null &&!noofOrderAdapterModels.getTotalAmt().isEmpty()){
            orderItemViewHolder.cash_placedtv.setText(noofOrderAdapterModels.getTotalAmt());
        }
        if(noofOrderAdapterModels.getPaymentType()!=null &&!noofOrderAdapterModels.getPaymentType().isEmpty()){
            orderItemViewHolder.type_placedtv.setText(noofOrderAdapterModels.getPaymentType());
        }
        if(noofOrderAdapterModels.getUserName()!=null &&!noofOrderAdapterModels.getUserName().isEmpty()){
            orderItemViewHolder.usernameTv.setText(noofOrderAdapterModels.getUserName());
        }
        if(noofOrderAdapterModels.getAccept()==false && noofOrderAdapterModels.getReject()==false){
            orderItemViewHolder.acceptBt.setVisibility(View.VISIBLE);
            orderItemViewHolder.rejectBt.setVisibility(View.VISIBLE);
            orderItemViewHolder.accrejTv.setVisibility(View.GONE);
        }
        if(noofOrderAdapterModels.getAccept()==true && noofOrderAdapterModels.getReject()==false){
            orderItemViewHolder.acceptBt.setVisibility(View.GONE);
            orderItemViewHolder.rejectBt.setVisibility(View.GONE);
            orderItemViewHolder.accrejTv.setVisibility(View.VISIBLE);
            orderItemViewHolder.accrejTv.setText("Order is successfully accepted");
            orderItemViewHolder.accrejTv.setTextColor(ContextCompat.getColor(context, R.color.green_800));
        }
        if(noofOrderAdapterModels.getAccept()==false && noofOrderAdapterModels.getReject()==true){
            orderItemViewHolder.acceptBt.setVisibility(View.GONE);
            orderItemViewHolder.rejectBt.setVisibility(View.GONE);
            orderItemViewHolder.accrejTv.setVisibility(View.VISIBLE);
            orderItemViewHolder.accrejTv.setText("Order is rejected");
            orderItemViewHolder.accrejTv.setTextColor(ContextCompat.getColor(context, R.color.red_800));
        }
    }

    @Override
    public int getItemCount() {
        return noofOrderAdapterModel.size();
    }

}

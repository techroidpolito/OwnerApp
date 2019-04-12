package com.gratus.ownerapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gratus.ownerapp.R;
import com.gratus.ownerapp.adapter.NoofOrderAdapter;
import com.gratus.ownerapp.model.NoofOrderAdapterModel;
import com.gratus.ownerapp.util.interfaces.AcceptMoreClickItemListerner;
import com.gratus.ownerapp.util.interfaces.OrderMoreClickItemListerner;
import com.gratus.ownerapp.util.interfaces.RejectMoreClickItemListerner;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MoreOrderAdapter extends RecyclerView.Adapter {
    private int DETAILS = 1;
    private int ADDRESS = 2;
    private int ITEM = 3;
    private ArrayList<NoofOrderAdapterModel> noofOrderAdapterModel = new ArrayList<>();
    Context context;
    private MoreOrderAdapter.OrderItemViewHolder orderItemViewHolder;
    private MoreOrderAdapter.AddressItemViewHolder addressItemViewHolder;
    private MoreOrderAdapter.ItemItemViewHolder itemItemViewHolder;
    public MoreOrderAdapter(ArrayList<NoofOrderAdapterModel> noofOrderAdapterModel, Context context) {
        this.noofOrderAdapterModel = noofOrderAdapterModel;
        this.context =context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        if (viewType == DETAILS) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_order_payment_item, null);
            return new MoreOrderAdapter.OrderItemViewHolder(itemView);
        }
        else if (viewType == ADDRESS) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_order_address, null);
            return new MoreOrderAdapter.AddressItemViewHolder(itemView);
        }
        else if (viewType == ITEM) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_order_item, null);
            return new MoreOrderAdapter.ItemItemViewHolder(itemView);
        }
        else{
            return null;
        }
    }

    public class OrderItemViewHolder extends RecyclerView.ViewHolder {
        TextView usernameTv,orderNoTv,timeTv,noitem_placedtv,cash_placedtv,type_placedtv;
        public OrderItemViewHolder(View itemView) {
            super(itemView);
            usernameTv = itemView.findViewById(R.id.usernameTv);
            orderNoTv = itemView.findViewById(R.id.orderNoTv);
            timeTv =  itemView.findViewById(R.id.timeTv);
            noitem_placedtv =  itemView.findViewById(R.id.noitem_placedtv);
            cash_placedtv =  itemView.findViewById(R.id.cash_placedtv);
            type_placedtv =  itemView.findViewById(R.id.type_placedtv);
        }
    }

    public class AddressItemViewHolder extends RecyclerView.ViewHolder {
        TextView headertv,addresstv;
        public AddressItemViewHolder(View itemView) {
            super(itemView);
            headertv = itemView.findViewById(R.id.headertv);
            addresstv = itemView.findViewById(R.id.addresstv);
        }
    }

    public class ItemItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemnametv,noitemtv,noitem_placedtv,notetv;
        public ItemItemViewHolder(View itemView) {
            super(itemView);
            itemnametv = itemView.findViewById(R.id.itemnametv);
            noitemtv = itemView.findViewById(R.id.noitemtv);
            noitem_placedtv =  itemView.findViewById(R.id.noitem_placedtv);
            notetv =  itemView.findViewById(R.id.notetv);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NoofOrderAdapterModel noofOrderAdapterModels = noofOrderAdapterModel.get(position);
        Integer layoutType = noofOrderAdapterModels.getLayoutType();
        if(layoutType== DETAILS) {
            orderItemViewHolder = (MoreOrderAdapter.OrderItemViewHolder) holder;
            if (noofOrderAdapterModels.getOrderNo() != null && !noofOrderAdapterModels.getOrderNo().isEmpty()) {
                orderItemViewHolder.orderNoTv.setText(noofOrderAdapterModels.getOrderNo());
            }
            if (noofOrderAdapterModels.getTimeOrder() != null && !noofOrderAdapterModels.getTimeOrder().isEmpty()) {
                orderItemViewHolder.timeTv.setText(noofOrderAdapterModels.getTimeOrder());
            }
            if (noofOrderAdapterModels.getNoItems() != null && !noofOrderAdapterModels.getNoItems().isEmpty()) {
                orderItemViewHolder.noitem_placedtv.setText(noofOrderAdapterModels.getNoItems());
            }
            if (noofOrderAdapterModels.getTotalAmt() != null && !noofOrderAdapterModels.getTotalAmt().isEmpty()) {
                orderItemViewHolder.cash_placedtv.setText(noofOrderAdapterModels.getTotalAmt());
            }
            if (noofOrderAdapterModels.getPaymentType() != null && !noofOrderAdapterModels.getPaymentType().isEmpty()) {
                orderItemViewHolder.type_placedtv.setText(noofOrderAdapterModels.getPaymentType());
            }
            if (noofOrderAdapterModels.getUserName() != null && !noofOrderAdapterModels.getUserName().isEmpty()) {
                orderItemViewHolder.usernameTv.setText(noofOrderAdapterModels.getUserName());
            }
        }
        if(layoutType== ADDRESS) {
            addressItemViewHolder = (MoreOrderAdapter.AddressItemViewHolder) holder;
            if (noofOrderAdapterModels.getAddress() != null && !noofOrderAdapterModels.getAddress().isEmpty()) {
                addressItemViewHolder.headertv.setText(noofOrderAdapterModels.getHeader());
                addressItemViewHolder.addresstv.setText(noofOrderAdapterModels.getAddress());
            }
        }
        if(layoutType== ITEM) {
            itemItemViewHolder = (MoreOrderAdapter.ItemItemViewHolder) holder;
            if (noofOrderAdapterModels.getItemName() != null && !noofOrderAdapterModels.getItemName().isEmpty()) {
                itemItemViewHolder.itemnametv.setText(noofOrderAdapterModels.getItemName());
                itemItemViewHolder.noitem_placedtv.setText(noofOrderAdapterModels.getNoItems());
            }
            if (noofOrderAdapterModels.getNote() != null && !noofOrderAdapterModels.getNote().isEmpty()) {
                itemItemViewHolder.notetv.setVisibility(View.VISIBLE);
                itemItemViewHolder.notetv.setText(noofOrderAdapterModels.getNote());
            }else {
                itemItemViewHolder.notetv.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return noofOrderAdapterModel.size();
    }

    @Override
    public int getItemViewType(int position) {
        return noofOrderAdapterModel.get(position).getLayoutType();
    }

}

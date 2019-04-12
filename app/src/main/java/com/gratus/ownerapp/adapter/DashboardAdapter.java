package com.gratus.ownerapp.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gratus.ownerapp.R;
import com.gratus.ownerapp.model.DashboardAdapterModel;
import com.gratus.ownerapp.util.interfaces.OnItemClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DashboardAdapter  extends RecyclerView.Adapter {

    private int MENU = 1;
    private int OFFER = 2;
    private int ORDER = 3;
    private int PROFILE = 4;
    private ArrayList<DashboardAdapterModel> dashboardAdapterModel = new ArrayList<>();
    private MenuItemViewHolder menuItemViewHolder;
    private OfferItemViewHolder offerItemViewHolder;
    private OrderItemViewHolder orderItemViewHolder;
    private ProfileItemViewHolder profileItemViewHolder;
    private OnItemClickListener mListener;


    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    public DashboardAdapter(ArrayList<DashboardAdapterModel> dashboardAdapterModel) {
        this.dashboardAdapterModel=dashboardAdapterModel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        if (viewType == MENU){
            itemView = LayoutInflater.from(parent.getContext()).inflate( R.layout.dashboard_item, null);
            return new DashboardAdapter.MenuItemViewHolder(itemView);
        }
        else if (viewType == OFFER){
            itemView = LayoutInflater.from(parent.getContext()).inflate( R.layout.dashboard_item, null);
            return new DashboardAdapter.OfferItemViewHolder(itemView);
        }
        else if (viewType == ORDER){
            itemView = LayoutInflater.from(parent.getContext()).inflate( R.layout.dashboard_item, null);
            return new DashboardAdapter.OrderItemViewHolder(itemView);
        }
        else if (viewType == PROFILE) {
            itemView = LayoutInflater.from(parent.getContext()).inflate( R.layout.dashboard_item, null);
            return new DashboardAdapter.ProfileItemViewHolder(itemView);
        }
        else{
            itemView = LayoutInflater.from(parent.getContext()).inflate( R.layout.dashboard_item, null);
            return new DashboardAdapter.ProfileItemViewHolder(itemView);
        }
    }

    private class MenuItemViewHolder extends RecyclerView.ViewHolder {
        TextView textTv;
        ImageView iconImg;
        RelativeLayout cardRl;
        MenuItemViewHolder(View v) {
            super(v);
            textTv = v.findViewById(R.id.textTv);
            iconImg = v.findViewById(R.id.iconImg);
            cardRl = v.findViewById(R.id.cardRl);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    private class OfferItemViewHolder extends RecyclerView.ViewHolder {
        TextView textTv;
        ImageView iconImg;
        RelativeLayout cardRl;
        OfferItemViewHolder(View v) {
            super(v);
            textTv = v.findViewById(R.id.textTv);
            iconImg = v.findViewById(R.id.iconImg);
            cardRl = v.findViewById(R.id.cardRl);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    private class OrderItemViewHolder extends RecyclerView.ViewHolder {
        TextView textTv;
        ImageView iconImg;
        RelativeLayout cardRl;
        OrderItemViewHolder(View v) {
            super(v);
            textTv = v.findViewById(R.id.textTv);
            iconImg = v.findViewById(R.id.iconImg);
            cardRl = v.findViewById(R.id.cardRl);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    private class ProfileItemViewHolder extends RecyclerView.ViewHolder {
        TextView textTv;
        ImageView iconImg;
        RelativeLayout cardRl;
        ProfileItemViewHolder(View v) {
            super(v);
            textTv = v.findViewById(R.id.textTv);
            iconImg = v.findViewById(R.id.iconImg);
            cardRl = v.findViewById(R.id.cardRl);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DashboardAdapterModel dashboardAdapterModels = dashboardAdapterModel.get(position);
        Integer layoutType = dashboardAdapterModels.getLayoutType();
        if(layoutType== MENU){
            menuItemViewHolder = (DashboardAdapter.MenuItemViewHolder) holder;
            menuItemViewHolder.textTv.setText(dashboardAdapterModels.getText());
            menuItemViewHolder.iconImg.setImageResource(dashboardAdapterModels.getDh_icon());
            menuItemViewHolder.cardRl.setBackgroundResource(dashboardAdapterModels.getBg_color());
        }
        if(layoutType== OFFER){
            offerItemViewHolder = (DashboardAdapter.OfferItemViewHolder) holder;
            offerItemViewHolder.textTv.setText(dashboardAdapterModels.getText());
            offerItemViewHolder.iconImg.setImageResource(dashboardAdapterModels.getDh_icon());
            offerItemViewHolder.cardRl.setBackgroundResource(dashboardAdapterModels.getBg_color());

        }
        if(layoutType== ORDER){
            orderItemViewHolder = (DashboardAdapter.OrderItemViewHolder) holder;
            orderItemViewHolder.textTv.setText(dashboardAdapterModels.getText());
            orderItemViewHolder.iconImg.setImageResource(dashboardAdapterModels.getDh_icon());
            orderItemViewHolder.cardRl.setBackgroundResource(dashboardAdapterModels.getBg_color());
        }
        if(layoutType== PROFILE){
            profileItemViewHolder = (DashboardAdapter.ProfileItemViewHolder) holder;
            profileItemViewHolder.textTv.setText(dashboardAdapterModels.getText());
            profileItemViewHolder.iconImg.setImageResource(dashboardAdapterModels.getDh_icon());
            profileItemViewHolder.cardRl.setBackgroundResource(dashboardAdapterModels.getBg_color());
        }
    }

    @Override
    public int getItemCount() {
        return dashboardAdapterModel.size();
    }
    @Override
    public int getItemViewType(int position) {
        return dashboardAdapterModel.get(position).getLayoutType();
    }
}


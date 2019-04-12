package com.gratus.ownerapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.gratus.ownerapp.R;
import com.gratus.ownerapp.model.RejectionAdapterModel;
import com.gratus.ownerapp.util.interfaces.RejectMoreClickItemListerner;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderRejectionAdapter extends RecyclerView.Adapter {
    private ArrayList<RejectionAdapterModel> rejectionAdapterModelArrayList = new ArrayList<>();
    Context context;
    private RejectionItemViewHolder rejectionItemViewHolder;
    private RejectMoreClickItemListerner rejectMoreClickItemListerner;
    public OrderRejectionAdapter(ArrayList<RejectionAdapterModel> rejectionAdapterModelArrayList, Context context) {
        this.rejectionAdapterModelArrayList = rejectionAdapterModelArrayList;
        this.context =context;
    }
    public void setOrderMoreClickItemListerner(RejectMoreClickItemListerner listener) {
        rejectMoreClickItemListerner = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate( R.layout.rejection_reason_items, null);
        return new OrderRejectionAdapter.RejectionItemViewHolder(itemView);
    }

    public class RejectionItemViewHolder extends RecyclerView.ViewHolder {
        TextView reasonTv;
        CheckBox chkSelected;
        public RejectionItemViewHolder(View itemView) {
            super(itemView);
            reasonTv = itemView.findViewById(R.id.reasonTv);
            chkSelected = itemView.findViewById(R.id.chkSelected);
            chkSelected.setOnClickListener(new View.OnClickListener() {
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
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RejectionAdapterModel rejectionAdapterModels = rejectionAdapterModelArrayList.get(position);
        rejectionItemViewHolder = (RejectionItemViewHolder) holder;
        rejectionItemViewHolder.reasonTv.setText(rejectionAdapterModels.getReason());
        rejectionItemViewHolder.chkSelected.setChecked(rejectionAdapterModels.getSelected());
    }

    @Override
    public int getItemCount() {
        return rejectionAdapterModelArrayList.size();
    }

}

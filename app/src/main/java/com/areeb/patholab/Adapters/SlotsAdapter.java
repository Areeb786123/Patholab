package com.areeb.patholab.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.areeb.patholab.Model.SlotsModel;
import com.areeb.patholab.R;

import java.util.ArrayList;

public class SlotsAdapter extends RecyclerView.Adapter<SlotsAdapter.mViewHolder> {
ArrayList<SlotsModel> slotsModelList;

    public SlotsAdapter(ArrayList<SlotsModel> slotsModelList) {
        this.slotsModelList = slotsModelList;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userappointmentlay,parent,false);
        return  new mViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

        SlotsModel LabSlotsModel = slotsModelList.get(position);
        holder.LabName.setText(LabSlotsModel.getLabName());
        Log.e("testing1",LabSlotsModel.getLabName().toString());

    }

    @Override
    public int getItemCount() {
        return (slotsModelList == null) ? 0 :slotsModelList.size();
    }

    public class mViewHolder extends  RecyclerView.ViewHolder{

        TextView LabName;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            LabName = itemView.findViewById(R.id.LabNamex);
        }
    }
}

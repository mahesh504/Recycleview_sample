package com.mahesh504.recycleview_sample.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahesh504.recycleview_sample.R;
import com.mahesh504.recycleview_sample.model.PropertyModel;
import com.mahesh504.recycleview_sample.util.CommonUtl;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PropertyListAdapter extends RecyclerView.Adapter<PropertyListAdapter.RcvViewHolder> {

    private List<PropertyModel> propertyModelList = new ArrayList<>();
    private Context mContext;

    public PropertyListAdapter(List<PropertyModel> propertyModelList,Context mContext) {

        this.propertyModelList = propertyModelList;
        this.mContext= mContext;

    }

    @NonNull
    @Override
    public RcvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_pro_row,null);
        return new RcvViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RcvViewHolder holder, int position) {
        Picasso.with(mContext).load(propertyModelList.get(position).getPro_image()).transform(new CommonUtl.CircleTransform()).into(holder.img_pr);
        holder.txt_name.setText(propertyModelList.get(position).getPro_name());
        holder.txt_ads.setText(propertyModelList.get(position).getPro_adrs());

    }


    @Override
    public int getItemCount() {
        if(propertyModelList.size() > 0)
        return propertyModelList.size();
        else
            return 0;
    }
    class RcvViewHolder extends RecyclerView.ViewHolder{
        ImageView img_pr;
        TextView txt_name,txt_ads;
        public RcvViewHolder(View itemView) {
            super(itemView);
            img_pr = itemView.findViewById(R.id.img_pro);
            txt_name = itemView.findViewById(R.id.pro_name);
            txt_ads = itemView.findViewById(R.id.pro_ads);
        }
    }
}

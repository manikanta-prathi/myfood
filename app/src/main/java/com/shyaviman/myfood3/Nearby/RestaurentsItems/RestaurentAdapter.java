package com.shyaviman.myfood3.Nearby.RestaurentsItems;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shyaviman.myfood3.Items.ItemsAdapter;
import com.shyaviman.myfood3.Model.VegItemsModel;
import com.shyaviman.myfood3.R;

import java.util.ArrayList;

public class RestaurentAdapter extends RecyclerView.Adapter<RestaurentAdapter.RestaurentInfo> {
    Context context;
  ArrayList<VegItemsModel> arrayList;
    private VegItem mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(VegItem listener){
        mListener = listener;

    }

    public RestaurentAdapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RestaurentInfo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.restaurent_row,viewGroup,false);
        return new RestaurentInfo(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurentInfo restaurentInfo, int i) {
        restaurentInfo.tv_name.setText(arrayList.get(i).getTitle());
        restaurentInfo.tv_price.setText(arrayList.get(i).getPrice());




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class RestaurentInfo extends RecyclerView.ViewHolder {
        TextView tv_name,tv_price;
        CardView cv_vi;
        public RestaurentInfo(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.row_iname_r);
            tv_price = itemView.findViewById(R.id.row_price_r);
            cv_vi = itemView.findViewById(R.id.cvVI);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener!=null){
                        int position = getAdapterPosition();
                        if (position !=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });


        }
    }
}

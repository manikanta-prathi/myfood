package com.shyaviman.myfood3.Items;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shyaviman.myfood3.Nearby.RestaurentsItems.NonVegItemModel;
import com.shyaviman.myfood3.Nearby.RestaurentsItems.NonVeg_Item;

import com.shyaviman.myfood3.R;
import com.shyaviman.myfood3.Nearby.RestaurentsItems.RestaurentNearby;

import java.util.ArrayList;

public class ItemRestaurentAdapter extends RecyclerView.Adapter<ItemRestaurentAdapter.IRInfo> {
    Context context;
    ArrayList<NonVegItemModel> arrayList;
    private NonVeg_Item mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(NonVeg_Item listener){
        mListener = listener;

    }

    public ItemRestaurentAdapter(Context context, ArrayList<NonVegItemModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public IRInfo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.items_restaurent_row,viewGroup,false);
        return new IRInfo(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IRInfo irInfo, int i) {
        irInfo.tv2.setText(arrayList.get(i).getNames());
        irInfo.tv3.setText(arrayList.get(i).getPrice());



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class IRInfo extends RecyclerView.ViewHolder {
        TextView tv2,tv3;
        LinearLayout lR;
        public IRInfo(@NonNull View itemView) {
            super(itemView);
            tv2 = itemView.findViewById(R.id.tvName_Rrow);
            tv3 = itemView.findViewById(R.id.tvPrice_Rrow);
            lR = itemView.findViewById(R.id.lL);
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

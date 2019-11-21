package com.shyaviman.myfood3.Items;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shyaviman.myfood3.Model.ItemsModel;
import com.shyaviman.myfood3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsInfo> {
    Context context;
    ArrayList<ItemsModel> arrayList;
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;

    }

    public ItemsAdapter(Context context, ArrayList<ItemsModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ItemsInfo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.items_row,viewGroup,false);

        return new ItemsInfo(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsInfo itemsInfo, final int i) {
        Picasso.with(context)
                .load(arrayList.get(i)
                        .getImages())
                .placeholder(R.drawable.loading).
                into(itemsInfo.img_row_item);
        itemsInfo.name_row_item.setText(arrayList.get(i).getTitle());



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ItemsInfo extends RecyclerView.ViewHolder {
        ImageView img_row_item;
        TextView name_row_item;

        public ItemsInfo(@NonNull View itemView) {
            super(itemView);
            img_row_item = itemView.findViewById(R.id.row_img_i);
            name_row_item = itemView.findViewById(R.id.row_tv_i);

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

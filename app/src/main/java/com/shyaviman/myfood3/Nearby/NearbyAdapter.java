package com.shyaviman.myfood3.Nearby;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shyaviman.myfood3.Model.NearbyModel;
import com.shyaviman.myfood3.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.NearbyInfo> {
    Context context;
    ArrayList<NearbyModel> arrayList;
    private Nearby mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(Nearby listener){
        mListener = listener;

    }

    public NearbyAdapter(Context context, ArrayList<NearbyModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public NearbyInfo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.near_row, viewGroup, false);

        return new NearbyInfo(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NearbyInfo nearbyInfo, final int i) {
        Picasso.with(context)
                .load(arrayList.get(i)
                        .getSmallThumnail())
                .placeholder(R.drawable.loading).
                into(nearbyInfo.row_img_n);
        nearbyInfo.row_title_n.setText(arrayList.get(i).getTitle());
        nearbyInfo.row_rating_n.setText(arrayList.get(i).getRating());
        nearbyInfo.row_location_n.setText(arrayList.get(i).getLocation());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class NearbyInfo extends RecyclerView.ViewHolder {
        ImageView row_img_n;
        TextView row_title_n, row_location_n, row_rating_n;
        public NearbyInfo(@NonNull View itemView) {
            super(itemView);
            row_img_n = itemView.findViewById(R.id.near_row_img);
            row_title_n = itemView.findViewById(R.id.near_title);
            row_location_n = itemView.findViewById(R.id.location_n);
            row_rating_n = itemView.findViewById(R.id.rating_n);
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

package com.shyaviman.myfood3.VALib;

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
import com.shyaviman.myfood3.Model.ItemsModel;
import com.shyaviman.myfood3.R;

import java.util.ArrayList;

public class ArtclesAdapter extends RecyclerView.Adapter<ArtclesAdapter.ArtclesInfo> {
    Context context;
    ArrayList<ArticlesDisplayableModel> arrayList;
    private Artcles mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(Artcles listener){
        mListener = listener;

    }

    public ArtclesAdapter(Context context, ArrayList<ArticlesDisplayableModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ArtclesInfo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.article_row,viewGroup,false);

        return new ArtclesInfo(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtclesInfo artclesInfo, final int i) {
        artclesInfo.tv_row_a.setText(arrayList.get(i).getTitle());

    }
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ArtclesInfo extends RecyclerView.ViewHolder {
        TextView tv_row_a;
        CardView cvR;
        public ArtclesInfo(@NonNull View itemView) {
            super(itemView);
            tv_row_a = itemView.findViewById(R.id.row_tv_a);
            cvR = itemView.findViewById(R.id.cv_a);
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

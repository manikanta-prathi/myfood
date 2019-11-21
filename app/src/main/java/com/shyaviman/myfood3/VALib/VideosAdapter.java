package com.shyaviman.myfood3.VALib;


import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.shyaviman.myfood3.R;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoVewHolder>{
    ProgressDialog loading;
    List<YoutubeVideo> youtubeVideoList;


    public VideosAdapter(List<YoutubeVideo> youtubeVideoList, String[] names_v) {
        this.youtubeVideoList = youtubeVideoList;

    }

    @NonNull
    @Override
    public VideoVewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_row,viewGroup,false);
        return new VideoVewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VideoVewHolder videoVewHolder, int i) {

        videoVewHolder.videoWeb.loadData(youtubeVideoList.get(i).getVideoUri(),"text/html","utf-8");


    }

    @Override
    public int getItemCount() {
        return youtubeVideoList.size();

    }

    public class VideoVewHolder extends RecyclerView.ViewHolder {
        public WebView videoWeb;
        public TextView tv_name;

        public VideoVewHolder(@NonNull View itemView) {
            super(itemView);
            videoWeb=(WebView)itemView.findViewById(R.id.webVideo);


            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient(){
        });
    }
}
}
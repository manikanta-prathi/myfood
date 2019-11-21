package com.shyaviman.myfood3.VALib;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shyaviman.myfood3.R;

import java.util.Vector;

import static java.security.AccessController.getContext;


/**
 * A simple {@link Fragment} subclass.
 */
public class Videos extends Fragment {
    RecyclerView recyclerView;


    //vector for video urls
    Vector<YoutubeVideo> youtubeVideos = new Vector<YoutubeVideo>();


    public Videos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_videos, container, false);
        recyclerView = v.findViewById(R.id.recycler);

        recyclerView.setHasFixedSize(true);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }
        String names[] = {"chicken biryani", "fish fry", "fish curry", "dhum biryani", "egg fride rice"};
        //load video list
        youtubeVideos.add(new YoutubeVideo("<<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Qsqak4VjhIY\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/XEe8bz4cLrY\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo(" <iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/YFD6HqTfWkk\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo(" <iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/JLta2Y7vlZc\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo(" <iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/YpZoIAvnkBw\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/8_fIChJu2LA\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/SoDlKCM0a9M\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_GXVGbELBnw\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_GXVGbELBnw\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo(" <iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_juEoR5ZKfA\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo(" <iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/JLta2Y7vlZc\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        VideosAdapter videoAdapter = new VideosAdapter(youtubeVideos, names);
        recyclerView.setAdapter(videoAdapter);


        return v;
    }


}

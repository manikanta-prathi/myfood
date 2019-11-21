package com.shyaviman.myfood3.VALib;

public class YoutubeVideo {
    String videoUri;
    public YoutubeVideo(){
    }
    public YoutubeVideo(String videoUri){
        this.videoUri=videoUri;
    }
    public String getVideoUri(){
        return  videoUri;
    }
    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }
}

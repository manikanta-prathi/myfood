package com.shyaviman.myfood3.Model;

public class NearbyModel {
    String title;
    String  location;
    String rating;
    String smallThumnail;

    public NearbyModel(String title, String location, String rating, String smallThumnail) {
        this.title = title;
        this.location = location;
        this.rating = rating;
        this.smallThumnail = smallThumnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSmallThumnail() {
        return smallThumnail;
    }

    public void setSmallThumnail(String smallThumnail) {
        this.smallThumnail = smallThumnail;
    }
}

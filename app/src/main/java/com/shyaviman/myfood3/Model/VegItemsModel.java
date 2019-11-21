package com.shyaviman.myfood3.Model;

public class VegItemsModel {
    String title;
    String price;
    String images;

    public VegItemsModel(String title, String price, String images) {
        this.title = title;
        this.price = price;
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}

package com.shyaviman.myfood3.Model;

public class ItemsModel {

    String images;
    String title;
    String  price;

    public ItemsModel(String images, String title, String price) {
        this.images = images;
        this.title = title;
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
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
}

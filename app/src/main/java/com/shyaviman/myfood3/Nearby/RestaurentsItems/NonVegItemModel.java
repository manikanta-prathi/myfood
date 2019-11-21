package com.shyaviman.myfood3.Nearby.RestaurentsItems;

public class NonVegItemModel {
    String names;
    String price;
    String images;

    public NonVegItemModel(String names, String price, String images) {
        this.names = names;
        this.price = price;
        this.images = images;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
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


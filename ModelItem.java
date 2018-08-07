package com.example.kiselev.myapplication;

import java.util.ArrayList;
import java.util.List;

class ModelItem {
    private String author;
    private int imgID;

    public ModelItem(String author, int imgID) {
        this.author = author;
        this.imgID = imgID;
    }

    public String getAuthor() {
        return author;
    }

    public int getImgID() {
        return imgID;
    }

    public static List<ModelItem> getFakeItems () {
        ArrayList<ModelItem> itemList = new ArrayList<>();
        itemList.add(new ModelItem( "nn", R.drawable.ic_launcher));
        return itemList;
    }
}

package com.bignerdranch.android.recipeapp;

public class Food {

    private String name; // название
    private String link;  // столица
    private int imgResource; // ресурс флага

    public Food(String name, String link, int img){

        this.name=name;
        this.link=link;
        this.imgResource=img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}

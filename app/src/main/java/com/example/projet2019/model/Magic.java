package com.example.projet2019.model;

import com.google.gson.annotations.SerializedName;

public class Magic {


    private String name;
    private String imageUrl;


    public String getName(){
        return name;
    }

    public String getImage(){
        return imageUrl;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setImage(String image){
        imageUrl = image;
    }
}


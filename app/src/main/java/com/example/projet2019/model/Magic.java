package com.example.projet2019.model;

import com.google.gson.annotations.SerializedName;

public class Magic {


    private String name;
    private String imageUrl;
    private String type;
    private String rarity;
    private String power;
    private String toughness;
    private String colors;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }
}


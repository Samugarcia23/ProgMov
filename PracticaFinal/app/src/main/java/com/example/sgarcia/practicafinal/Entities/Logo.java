package com.example.sgarcia.practicafinal.Entities;

public class Logo {

    String name;
    int img;
    boolean guessed;

    public Logo(){}

    public Logo(String name, int img, boolean guessed) {
        this.name = name;
        this.img = img;
        this.guessed = guessed;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGuessed() {
        return guessed;
    }

    public void setGuessed(boolean guessed) {
        this.guessed = guessed;
    }
}

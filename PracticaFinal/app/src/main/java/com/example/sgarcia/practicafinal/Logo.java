package com.example.sgarcia.practicafinal;

public class Logo {

    String name;
    int img, value;
    //boolean guessed

    public Logo(){}

    public Logo(String name, int img, int value) {
        this.name = name;
        this.img = img;
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

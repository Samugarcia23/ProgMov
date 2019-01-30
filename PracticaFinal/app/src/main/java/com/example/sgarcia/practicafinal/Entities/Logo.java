package com.example.sgarcia.practicafinal.Entities;

/*
 *
 *   Clase Logo. Contiene:
 *
 *   - name --> Nombre del logo
 *   - img --> imagen del logo
 *   - guessed --> Logo acertado o no acertado
 *
 */

public class Logo {

    //Definicion de parametros

    private String name;
    private int img;
    private boolean guessed;

    //Constructor por defecto

    public Logo(){}

    //Constructor por parametros

    public Logo(String name, int img, boolean guessed) {
        this.name = name;
        this.img = img;
        this.guessed = guessed;
    }

    //GETTERS & SETTERS

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

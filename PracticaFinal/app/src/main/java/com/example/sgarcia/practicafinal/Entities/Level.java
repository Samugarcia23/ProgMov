package com.example.sgarcia.practicafinal.Entities;

import java.util.ArrayList;

public class Level {

    private boolean isLocked;
    private String color;
    private ArrayList<Logo> levelLogos;
    private int idLevel;

    public Level(){}

    public Level (int id, String color, boolean isLocked, ArrayList<Logo> levelLogos){
        this.color = color;
        this.isLocked = isLocked;
        this.levelLogos = levelLogos;
        this.idLevel = id;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ArrayList<Logo> getLevelLogos() {
        return levelLogos;
    }

    public void setLevelLogos(ArrayList<Logo> levelLogos) {
        this.levelLogos = levelLogos;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }
}

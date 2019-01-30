package com.example.sgarcia.practicafinal.Entities;

import java.util.ArrayList;

/*
 *
 *   Clase Level. Contiene:
 *
 *   - isLocked --> Nivel desbloqueado o bloqueado
 *   - color --> Color del nivel
 *   - levelLogos --> Listado de logos que contiene el nivel
 *   - idLevel --> identificador del nivel
 *
 */

public class Level {

    //Definicion de parametros

    private boolean isLocked;
    private String color;
    private ArrayList<Logo> levelLogos;
    private int idLevel;

    //Constructor por defecto

    public Level(){}

    //Constructor por parametros

    public Level (int id, String color, boolean isLocked, ArrayList<Logo> levelLogos){
        this.color = color;
        this.isLocked = isLocked;
        this.levelLogos = levelLogos;
        this.idLevel = id;
    }

    //GETTERS & SETTERS

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

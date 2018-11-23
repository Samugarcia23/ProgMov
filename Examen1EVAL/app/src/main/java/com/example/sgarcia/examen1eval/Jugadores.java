package com.example.sgarcia.examen1eval;

import android.app.Application;

public class Jugadores extends Application {

    private String nombre;
    private int foto;

    public Jugadores(){

    }

    public Jugadores(String nombre, int foto){
        this.nombre = nombre;
        this.foto = foto;
    }

    public String getNombre(){return this.nombre;}

    public void setNombre(String nombre){this.nombre = nombre;}

    public int getFoto(){return this.foto;}

    public void setFoto(int foto){this.foto = foto;}


}

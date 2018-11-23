package com.example.sgarcia.examen1eval;

public class JugadorFutbol extends Jugadores{

    String posicion;

    public JugadorFutbol(){
        super();
    }

    public JugadorFutbol(String posicion, String nombre, int foto){

        this.posicion = posicion;
        super.setNombre(nombre);
        super.setFoto(foto);

    }

    public String getPosicion(){return this.posicion;}

    public void setPosicion(String posicion){this.posicion = posicion;}

}

package com.example.sgarcia.examen1eval;

public class JugadorBasket extends Jugadores {

    int puntos, rebotes, asistencias;

    public JugadorBasket(){
        super();
    }

    public JugadorBasket(int puntos, int rebotes, int asistencias, String nombre, int foto){
        this.puntos = puntos;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        setNombre(nombre);
        setFoto(foto);
    }

    public int getPuntos(){return puntos;}

    public void setPuntos(int puntos){this.puntos = puntos;}

    public int getRebotes(){return rebotes;}

    public void setRebotes(int rebotes){this.rebotes = rebotes;}

    public int getAsistencias(){return asistencias;}

    public void setAsistencias(int asistencias){this.asistencias = asistencias;}

}

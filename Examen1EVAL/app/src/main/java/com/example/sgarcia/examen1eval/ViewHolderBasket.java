package com.example.sgarcia.examen1eval;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderBasket {

    ImageView foto;
    TextView nombre, rebotes, puntos, asistencias;

    ViewHolderBasket(ImageView foto, TextView nombre, TextView rebotes, TextView puntos, TextView asistencias){
        this.foto = foto;
        this.asistencias = asistencias;
        this.nombre = nombre;
        this.puntos = puntos;
        this.rebotes = rebotes;
    }

    public ImageView getFoto(){return this.foto;}

    public TextView getNombre(){return this.nombre;}

    public TextView getRebotes(){return this.rebotes;}

    public TextView getPuntos(){return this.puntos;}

    public TextView getAsistencias(){return this.asistencias;}

}

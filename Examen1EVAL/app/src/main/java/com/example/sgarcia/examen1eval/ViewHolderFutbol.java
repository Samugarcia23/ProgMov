package com.example.sgarcia.examen1eval;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderFutbol {

    ImageView foto;
    TextView nombre, posicion;

    ViewHolderFutbol(ImageView foto, TextView nombre, TextView posicion){

        this.foto = foto;
        this.nombre = nombre;
        this.posicion = posicion;

    }

    public ImageView getFoto(){
        return this.foto;
    }

    public TextView getNombre() {
        return this.nombre;
    }

    public TextView getPosicion() {
        return this.posicion;
    }
}

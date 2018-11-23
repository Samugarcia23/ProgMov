package com.example.sgarcia.examen1eval;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;

public class Edit extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ImageView fotoF;
    EditText etNombre;
    Spinner spinner;
    String nombre, pos;
    int foto;
    Switch aSwitch;
    ListadoJugadores listadoJugadores;
    String posiciones [];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);

        nombre = getIntent().getParcelableExtra("Nombre");
        pos = getIntent().getParcelableExtra("Posicion");
        foto = getIntent().getParcelableExtra("Foto");
        aSwitch = findViewById(R.id.swEditar);
        aSwitch.setOnCheckedChangeListener(this);

        if(aSwitch.isChecked())
            rellenarFormulario(nombre, pos, foto);
    }

    public void rellenarFormulario(String nom, String pos, int foto){
        fotoF = findViewById(R.id.imageView);
        etNombre = findViewById(R.id.etNombre);
        spinner = findViewById(R.id.spinner);
        listadoJugadores.listaFutbol();
        for (int i = 0; i<listadoJugadores.listaFutbol().size();i++){
            posiciones = new String[i];
            posiciones[i] = listadoJugadores.listaFutbol().get(i).getPosicion();
        }
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, posiciones);
        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    /*
    * Rellenar formulario rellena cada uno de los elementos del activity con los datos recibidos a traves del intent
    * Falta por implementar el boton añadir posicion, el cual añadiria nuevas posiciones al array posiciones, el boton pondria
    * visible al edittext de las posiciones y al boton aceptar
    *
    * El boton clonar enviaria a traves de un intent los datos que hay actualmente en cada elemento y crearia un nuevo jugador con los datos, guardar seria igual
    * borrar utilizaria el metodo remove de los arraylist para borrar dicho jugador
    *
    * La clase EditBasket es identica a esta salvo que tiene otros elementos
    * */

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked == true){
            rellenarFormulario(nombre, pos, foto);
        }
    }
}

package com.example.sam.intents_ej4_abrirmapa;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner spinner;
    Button btnAbrir;
    public String[] ubicaciones = {"Sevilla", "Madrid", "Barcelona",
            "Bilbao", "Almendralejo", "Solana de los Barros"};
    String ubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAbrir = findViewById(R.id.btnAbrirMaps);
        btnAbrir.setOnClickListener(this);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ubicaciones);
        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(ubicacion));
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(ubicaciones[i].equals("Sevilla")){
            ubicacion = "https://www.google.es/maps/place/Sevilla";
        }else {
            if (ubicaciones[i].equals("Madrid")) {
                ubicacion = "https://www.google.es/maps/place/Madrid";
            } else {
                if (ubicaciones[i].equals("Barcelona")) {
                    ubicacion = "https://www.google.es/maps/place/Barcelona";
                } else {
                    if (ubicaciones[i].equals("Bilbao")) {
                        ubicacion = "https://www.google.es/maps/place/Bilbao,+Vizcaya";
                    } else {
                        if (ubicaciones[i].equals("Almendralejo")) {
                            ubicacion = "https://www.google.es/maps/place/06200+Almendralejo,+Badajoz";
                        }else{
                            if (ubicaciones[i].equals("Solana de los Barros")) {
                                ubicacion = "https://www.google.es/maps/place/06209+Solana+de+los+Barros,+Badajoz";
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

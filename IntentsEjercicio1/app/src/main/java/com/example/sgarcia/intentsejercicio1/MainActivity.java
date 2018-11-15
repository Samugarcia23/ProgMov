package com.example.sgarcia.intentsejercicio1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class  MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener, AdapterView.OnItemSelectedListener {

    public static final int CAMERA_PIC_REQUEST = 1;
    public String[] apps = {"Ejemplo Lista", "Ejemplo Lista Dinamica", "Camara",
                            "Spotify", "Instagram"};
    String path;
    Button boton;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.btnGo);
        boton.setOnClickListener(this);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, apps);
        spinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (apps[position].equals("Ejemplo Lista")) {
            path = "com.example.sgarcia.ejemplolista";
        } else {
            if (apps[position].equals("Ejemplo Lista Dinamica"))  {
                path = "com.example.sgarcia.ejemplolistadinamica";
            } else {
                if (apps[position].equals("Camara")){
                    path = "android.media.action.IMAGE_CAPTURE";
                } else {
                    if (apps[position].equals("Spotify")) {
                        path = "com.spotify.music";
                    } else {
                        if (apps[position].equals("Instagram")) {
                            path = "com.instagram.android";
                        }
                    }
                }
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        path = "";
    }

    @Override
    public void onClick(View v) {
        if (path.equals("android.media.action.IMAGE_CAPTURE")){
            Intent photo= new Intent(path);
            startActivityForResult(photo, CAMERA_PIC_REQUEST);
            path = "";
        }

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(path);
        if (launchIntent != null) {
            startActivity(launchIntent);//null pointer check in case package name was not found
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

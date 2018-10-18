package com.example.sgarcia.ejercicio4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private Button bsig, bant;
    private int imagen_actual;
    private int[] imagenes = {R.drawable.perro1, R.drawable.perro2, R.drawable.perro3, R.drawable.perro4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrarImg();
        selector();
    }

    public void mostrarImg(){
        img= findViewById(R.id.img1);
    }

    public void selector(){
        bsig=findViewById(R.id.bsig);
        bant=findViewById(R.id.bant);
        bsig.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                imagen_actual++;
                imagen_actual=imagen_actual%imagenes.length;
                img.setImageResource(imagenes[imagen_actual]);
            }
        });

        bant.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                imagen_actual--;
                if (imagen_actual<0){
                    imagen_actual=imagenes.length-1;
                }
                img.setImageResource(imagenes[imagen_actual]);
            }
        });
    }


}

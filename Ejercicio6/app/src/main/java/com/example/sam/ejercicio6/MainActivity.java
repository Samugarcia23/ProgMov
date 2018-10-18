package com.example.sam.ejercicio6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton imb;
    private int index;
    private int[] imagenes = {R.drawable.foto1, R.drawable.foto2, R.drawable.foto3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrarImg();
    }


    public void mostrarImg(){
        imb = findViewById(R.id.imb);
        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                index = index % imagenes.length;
                imb.setImageResource(imagenes[index]);
            }
        });


    }

}
